import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LabelClock {

    public static void main(String[] args) {
        new LabelClock();
    }

    protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm.ss");
    private JLabel clock;

    public LabelClock() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                clock = new JLabel();
                tick();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(clock);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tick();
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();
            }
        });
    }

    protected void tick() {
        clock.setText(DATE_FORMAT.format(new Date()));
    }

}