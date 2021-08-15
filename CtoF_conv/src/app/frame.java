package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class frame extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 365);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txt_celin = new JTextArea();
		txt_celin.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_celin.setBounds(48, 101, 197, 28);
		contentPane.add(txt_celin);
		
		JTextArea txt_fahout = new JTextArea();
		txt_fahout.setEditable(false);
		txt_fahout.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		txt_fahout.setBounds(48, 170, 197, 28);
		contentPane.add(txt_fahout);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Celcius", "Fahrenheit", "Kelvin"}));
		comboBox.setBounds(48, 79, 197, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Celcius", "Fahrenheit", "Kelvin"}));
		comboBox_1.setBounds(48, 148, 197, 22);
		contentPane.add(comboBox_1);
		
		JLabel debugText = new JLabel("");
		debugText.setForeground(new Color(255, 0, 0));
		debugText.setHorizontalAlignment(SwingConstants.CENTER);
		debugText.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		debugText.setBounds(48, 204, 197, 22);
		contentPane.add(debugText);
		
		
		JButton ctof = new JButton("Convert");
		ctof.setForeground(Color.BLACK);
		ctof.setBackground(Color.DARK_GRAY);
		ctof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String degerS = txt_celin.getText();
					double deger = Double.parseDouble(degerS);					
					String s = convert(comboBox, comboBox_1, deger) + "";
					
					txt_fahout.setText(s);									
				}
				catch(Exception edd) {
					System.out.println("Invalid entry");
					debugText.setText("Invalid Entry");
					th(debugText);
				}											
			}
		});
		ctof.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ctof.setBounds(48, 227, 197, 36);
		contentPane.add(ctof);
		
		JLabel lblNewLabel = new JLabel("Temperature Converter");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 22, 197, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblWitnnsoft = new JLabel("witnnsoft , 2021");
		lblWitnnsoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblWitnnsoft.setForeground(Color.BLACK);
		lblWitnnsoft.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblWitnnsoft.setBounds(48, 297, 197, 28);
		contentPane.add(lblWitnnsoft);				
	}
	
	static double convert(JComboBox c1, JComboBox c2, double deger) {
		double d;
		// c to fah
		if(c1.getSelectedItem().toString() == "Celcius") {
			if(c2.getSelectedItem().toString() == "Celcius") {
				return deger;
			}
			else if(c2.getSelectedItem().toString() == "Fahrenheit") {
				d = deger * 1.8f + 32;
				return d;
			}
			else if(c2.getSelectedItem().toString() == "Kelvin") {
				d = deger + 273.15f;
				return d;
			}
			else {
				return deger;
			}
		}
		else if(c1.getSelectedItem().toString() == "Fahrenheit") {
			if(c2.getSelectedItem().toString() == "Celcius") {
				d = (deger - 32) / 1.8;
				return d;
			}
			else if(c2.getSelectedItem().toString() == "Fahrenheit") {
				return deger;
			}
			else if(c2.getSelectedItem().toString() == "Kelvin") {
				d = ((deger - 32)/1.8) + 273.15;
				return d;
			}
			else {
				return deger;
			}
		}
		else if(c1.getSelectedItem().toString() == "Kelvin") {
			if(c2.getSelectedItem().toString() == "Celcius") {
				d = deger - 273.15;
				return d;
			}
			else if(c2.getSelectedItem().toString() == "Fahrenheit") {
				d = (1.8 * (deger - 273.15)) + 32;
				return d;
			}
			else if(c2.getSelectedItem().toString() == "Kelvin") {
				return deger;
			}
			else {
				return deger;
			}
		}
		else {
			return deger;
		}
	}
	
	static void th(JLabel label){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                label.setText("");
            }
        });
        t1.start();
    }
}
