package com.example;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class MainFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 4159266806348540020L;

    private JFormattedTextField tf;
    private JButton clickBtn;


    public MainFrame(final String title) {
        initGUI(title);


    }

    private void initGUI(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            final MaskFormatter formatter = new MaskFormatter("###-##-####");
            tf = new JFormattedTextField(formatter);
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(tf, BorderLayout.NORTH);
            clickBtn = new JButton("Click me!");
            clickBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!tf.getText().matches(formatter.getMask())) {
                        System.err.println("Your Input does not match the pattern!");
                    } else {
                        System.out.println(tf.getText());
                    }
                }
            });
            panel.add(clickBtn, BorderLayout.SOUTH);
            this.getContentPane().add(panel, BorderLayout.CENTER);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.setSize(800, 600);
        this.setVisible(true);
    }
}