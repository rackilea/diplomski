import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application {
    public static void main(String[] args) {
        new Application();
    }

    public Application() {
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

        public TestPane() {
            setLayout(new GridLayout(4, 3));
            String labels[] = new String[] {"7", "8", "9", "4", "5", "6", "1", "2", "3", "", "0", ""};
            for (String label : labels) {
                if (label.trim().isEmpty()) {
                    add(new JLabel());
                } else {
                    add(new JButton(label));
                }
            }
        }

    }

}