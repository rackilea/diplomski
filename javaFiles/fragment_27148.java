import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TestPack {

    public static void main(String[] args) {
        new TestPack();
    }

    public TestPack() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TopPanel(), BorderLayout.NORTH);
                frame.add(new MiddlePanel(), BorderLayout.CENTER);
                frame.add(new UpdatePanel(), BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TopPanel extends JPanel {

        public TopPanel() {
            setBackground(Color.red);
            add(new JLabel("I'm on top"));
        }

    }

    public class MiddlePanel extends JPanel {

        public MiddlePanel() {
            setLayout(new BorderLayout());
            add(new JScrollPane(new JTable(new DefaultTableModel(new Object[]{"A", "B", "C"}, 5))));
        }

    }

    public class UpdatePanel extends JPanel {

        public UpdatePanel() {
            for (int index = 0; index < 5; index++) {
                add(new JLabel(Integer.toString(index)));
                add(new JTextField(5));
            }
            add(new JButton("Button"));
        }            
    }        
}