import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ClockGUI {

    public static void main(String[] args) {
        new ClockGUI();
    }

    public ClockGUI() {
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

    public class TestPane extends JPanel {

        private Timer timer;
        private JLabel clock;

        public TestPane() {
            setLayout(new GridBagLayout());
            clock = new JLabel("...");
            add(clock);
            timer = new Timer(1000, new ActionListener() {

                private boolean started = false;
                private long startTime = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!started) {
                        started = true;
                        startTime = System.currentTimeMillis();
                    } else {
                        long dif = System.currentTimeMillis() - startTime;
                        long seconds = dif / 1000;
                        clock.setText(Long.toString(seconds));
                        if (seconds >= 90) {
                            timer.stop();
                        }
                    }
                }
            });
            timer.start();
        }

    }

}