import com.apple.eawt.Application;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestBadge {

    public static void main(String[] args) {
        new TestBadge();
    }

    public TestBadge() {
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

        private JLabel label;
        private int count;

        public TestPane() {
            setLayout(new GridBagLayout());
            add((label = new JLabel("0")));
            Timer timer = new Timer(250, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    count++;
                    label.setText(Integer.toString(count));
                    Application.getApplication().setDockIconBadge(Integer.toString(count));
                }
            });
            timer.start();
        }

    }

}