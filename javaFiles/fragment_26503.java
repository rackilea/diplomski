import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
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

        private JTextField targetHours;
        private JTextField targetMins;
        private JTextField targetSeconds;

        private Instant futureTime;
        private Timer timer;

        private JLabel countDown;

        public TestPane() {

            setLayout(new GridBagLayout());

            targetHours = new JTextField("00", 2);
            targetMins = new JTextField("00", 2);
            targetSeconds = new JTextField("00", 2);

            JPanel targetPane = new JPanel(new GridBagLayout());
            targetPane.add(targetHours);
            targetPane.add(new JLabel(":"));
            targetPane.add(targetMins);
            targetPane.add(new JLabel(":"));
            targetPane.add(targetSeconds);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(8, 8, 8, 8);

            add(targetPane, gbc);

            JButton btn = new JButton("Start");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    futureTime = LocalDateTime.now()
                            .plusHours(Long.parseLong(targetHours.getText()))
                            .plusMinutes(Long.parseLong(targetMins.getText()))
                            .plusSeconds(Long.parseLong(targetSeconds.getText()))
                            .atZone(ZoneId.systemDefault()).toInstant();

                    if (timer != null) {
                        timer.stop();
                    }

                    countDown.setText("---");
                    timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Duration duration = Duration.between(Instant.now(), futureTime);
                            if (duration.isNegative()) {
                                timer.stop();
                                timer = null;
                                countDown.setText("00:00:00");
                            } else {
                                String formatted = String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
                                countDown.setText(formatted);
                            }
                        }
                    });
                    timer.start();
                }
            });

            add(btn, gbc);

            countDown = new JLabel("---");
            add(countDown, gbc);
        }

    }

}