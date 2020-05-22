import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClockMeBaby {

    public static void main(String[] args) {
        new ClockMeBaby();
    }

    public ClockMeBaby() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        protected static final DateFormat CLOCK_FORMAT = new SimpleDateFormat("hh:mm:ss a");
        private JLabel clock;

        public TestPane() {
            setLayout(new GridBagLayout());
            clock = new JLabel("...");
            clock.setFont(clock.getFont().deriveFont(Font.BOLD, 64f));
            add(clock);
            updateClock();

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateClock();
                }
            });
            timer.start();
        }

        protected void updateClock() {

            clock.setText(CLOCK_FORMAT.format(System.currentTimeMillis()));

        }

    }

}