import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class CountDownTimer {
    public CountDownTimer() {
        final JFrame frame = new JFrame();
        JButton button = new JButton("Open Dilaog");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new CountDownTimerDialog(frame, true, 5);
            }
        });

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class CountDownTimerDialog extends JDialog {
        private int count;

        public CountDownTimerDialog(JFrame parent, boolean modal, int seconds) {
            super(parent, modal);
            count = seconds;
            final JLabel countLabel = new JLabel(String.valueOf(seconds), JLabel.CENTER);
            countLabel.setFont(new Font("impact", Font.PLAIN, 36));
            JLabel message = new JLabel("Wait to Start Game");
            message.setFont(new Font("verdana", Font.BOLD, 20));

            JPanel wrapper = new JPanel(new BorderLayout());
            wrapper.setBorder(new EmptyBorder(10, 10, 10, 10));
            wrapper.add(countLabel);
            wrapper.add(message, BorderLayout.SOUTH);
            add(wrapper);

            Timer timer = new Timer(1000, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if (count == -1) {
                        dispose();
                    } else {
                        countLabel.setText(String.valueOf(count));
                        count--;
                    }
                }
            });
            timer.setInitialDelay(0);
            timer.start();

            pack();
            setLocationRelativeTo(parent);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new CountDownTimer();
            }
        });
    }
}