package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PNGCreatorWindow {

    private JFrame      frame;
    private JTextField  txtText;
    private PNGImage    imagePanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PNGCreatorWindow();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PNGCreatorWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        txtText = new JTextField(10);
        controlPanel.add(txtText);

        JButton btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                generatePNGImage();
            }
        });
        controlPanel.add(btnGenerate);

        imagePanel = new PNGImage();

        frame.getContentPane().add(controlPanel, BorderLayout.NORTH);
        frame.getContentPane().add(imagePanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    protected void generatePNGImage() {
        imagePanel.setText(txtText.getText());
        imagePanel.repaint();
    }

    public class PNGImage extends JPanel {

        private static final long   serialVersionUID    = 602718701626241645L;

        private String              text;

        public PNGImage() {
            setPreferredSize(new Dimension(400, 300));
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (this.text != null) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.red);
                g2.drawString(this.text, 100, 100);
            }
        }

    }

}