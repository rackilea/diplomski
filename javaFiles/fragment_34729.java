package com.ggl.testing;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimpleTest {

    private JFrame frame;
    private NewPanel newPanel;

    public void guiMethod() {
        frame = new JFrame("Libra's");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newPanel = new NewPanel();
        newPanel.setEndPoints(200, 100, 100, 200);
        frame.add(newPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SimpleTest c = new SimpleTest();
                c.guiMethod();

                Timer timer = new Timer();
                timer.schedule(c.new SimpleTimerTask(), 1000, 1000);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    public class NewPanel extends JPanel {
        private static final long serialVersionUID = -4695412639313981349L;

        private int x1, y1, x2, y2;

        public NewPanel() {
            this.setPreferredSize(new Dimension(250, 250));
        }

        public void setEndPoints(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g.drawLine(75, 75, 10, 10);
            g.drawLine(75, 75, x1, y1);
            g.drawLine(75, 75, x2, y2);
        }
    }

    public class SimpleTimerTask extends TimerTask {        
        int count;

        @Override
        public void run() {
            count += 5;
            final int x1 = 200 + count;
            final int y1 = 100 + count;
            final int x2 = 100 + count;
            final int y2 = 200 + count;
            // repaint(); i want to invoke paint component method from here , simply
            // to change the end point of line every second
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    newPanel.setEndPoints(x1, y1, x2, y2);
                    newPanel.repaint();
                }
            };
            SwingUtilities.invokeLater(runnable);
        }

    }

}