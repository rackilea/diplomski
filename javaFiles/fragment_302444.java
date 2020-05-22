package pkg3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

public class TimerDeclaration {
    private static final int DELAY = 1000;

    // the tm2 variable is visible throughout the class
    private Timer tm2 = new Timer(DELAY, new TimerListener());

    private JButton btStartTimer1 = new JButton("Start Timer 1");
    private JButton btStartTimer2 = new JButton("Start Timer 2");

    public TimerDeclaration() {
        btStartTimer1.addActionListener(e -> btStartTimer1ActionPerformed(e));
        btStartTimer2.addActionListener(e -> btStartTimer2ActionPerformed(e));
    }

    private void btStartTimer2ActionPerformed(ActionEvent e) {
        tm2.start(); // tm2 is visible throughout your program
    }

    private void btStartTimer1ActionPerformed(ActionEvent e) {
        javax.swing.Timer tm = new javax.swing.Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                // btAddOneActionPerformed(evt);
            }
        });
        tm.start(); // this is only visible inside here!!!
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub

        }
    }
}