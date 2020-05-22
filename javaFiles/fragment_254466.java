import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Drop {

    public static void main(String[] args) {
        new Drop();
    }

    public Drop() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {
        private Instant lastDropTime;
        private JLabel label;
        public TestPane() {
            setLayout(new BorderLayout());
            label = new JLabel("Drop in ...");
            add(label);

            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if (lastDropTime == null) {
                        lastDropTime = Instant.now();
                    }
                    // I'm using toMillis so I can display the time
                    // but you could just use toSeconds
                    Duration duration = Duration.between(lastDropTime, Instant.now());
                    long millis = duration.toMillis();
                    long seconds = duration.toSeconds();

                    if (seconds >= 1) {
                        // Drop down here...
                        lastDropTime = Instant.now();
                        millis = 1000;
                    }

                    label.setText("Drop in " + (1000 - millis));
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}