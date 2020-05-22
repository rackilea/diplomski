package com.ggl.testing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GenoTech implements Runnable {

    @Override
    public void run() {
        JFrame frame = new JFrame("GenoTECH IDE 1.0.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(new DrawingPanel());

        JPanel pnlButton = new JPanel();

        JButton button = new JButton("Add Project");
        button.addActionListener(new NewProjectActionListener());
        pnlButton.add(button);

        mainPanel.add(pnlButton);

        JPanel pain = new JPanel();
        JTextArea area = new JTextArea();
        pain.add(area);

        mainPanel.add(pain);

        frame.add(mainPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GenoTech());
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = -5718559965267054844L;

        public DrawingPanel() {
            this.setPreferredSize(new Dimension(700, 300));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GRAY);
            g2d.fillRect(0, 0, 700, 50);
            g2d.setStroke(new BasicStroke(100));

            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRect(553, 60, 535, 300);
            g2d.drawString("Project Input (Your Code)", 30, 90);

            g2d.setColor(Color.WHITE);
            g2d.fillRect(563, 620, 515, 100);

            g2d.setColor(Color.BLACK);
            g2d.drawString("Console.ChemLOG", 570, 640);
        }

    }

    // add project button
    public class NewProjectActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame frame2 = new JFrame("New Project");
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel mainPanel = new JPanel();

            JButton buttonOK = new JButton("Ok");
            mainPanel.add(buttonOK);

            JButton buttonCn = new JButton("Cancel");
            buttonCn.addActionListener(new ButtonCNActionListener());
            mainPanel.add(buttonCn);

            frame2.add(mainPanel);
            frame2.pack();
            frame2.setLocationByPlatform(true);
            frame2.setVisible(true);
        }

        public class ButtonCNActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
    }

}