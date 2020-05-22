package com.ggl.testing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CookieChaser implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CookieChaser());
    }

    private JLabel counterLabel;

    @Override
    public void run() {
        Counter counter = new Counter();

        JFrame frame = new JFrame("Cookie Chaser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        counterLabel = new JLabel(" ");
        mainPanel.add(counterLabel);

        frame.add(mainPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);

        new Thread(new Animation(this, counter)).start();
    }

    public void setCounterLabel(String text) {
        counterLabel.setText(text);
    }

    public class Counter {
        private int counter;

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public void incrementCounter() {
            this.counter++;
        }
    }

    public class Animation implements Runnable {

        private Counter counter;

        private CookieChaser cookieChaser;

        public Animation(CookieChaser cookieChaser, Counter counter) {
            this.cookieChaser = cookieChaser;
            this.counter = counter;
        }

        @Override
        public void run() {
            while (true) {
                counter.incrementCounter();
                repaint();
                sleep(1000L);
            }
        }

        private void repaint() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    cookieChaser.setCounterLabel(Integer.toString(counter
                            .getCounter()));
                }
            });
        }

        private void sleep(long duration) {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {

            }
        }
    }
}