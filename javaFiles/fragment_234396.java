import java.awt.event.*;
import javax.swing.*;

class CountDownProgressBar {

    Timer timer;
    JProgressBar progressBar;

    CountDownProgressBar() {
        progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 10);
        progressBar.setValue(10);
        ActionListener listener = new ActionListener() {
            int counter = 10;
            public void actionPerformed(ActionEvent ae) {
                counter--;
                progressBar.setValue(counter);
                if (counter<1) {
                    JOptionPane.showMessageDialog(null, "Kaboom!");
                    timer.stop();
                } 
            }
        };
        timer = new Timer(1000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, progressBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                CountDownProgressBar cdpb = new CountDownProgressBar();
            }
        });
    }
}