import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class RepaintDemo {

    JFrame frame = new JFrame("Repaint demo");
    JLabel labelFirst = new JLabel("First label");
    JLabel labelSecond = new JLabel("Second label");
    JLabel[] labels = { labelFirst, labelSecond };
    JPanel panel = new JPanel();
    Timer timer;
    int i = 0;

    public RepaintDemo() {
        // Wait for 3 seconds and then add label
        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(labels[i]);
                panel.repaint();
                panel.revalidate();
                i++;
                if (i == labels.length) {
                    timer.stop();
                }
            }
        });
        // Adds next label after every 3 seconds
        timer.setDelay(3000);
        timer.setRepeats(true);
        timer.start();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RepaintDemo();
            }
        });
    }

}