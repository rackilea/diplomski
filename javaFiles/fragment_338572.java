import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TabbedExample {

    public static void main(String[] args) {
        new TabbedExample();
    }

    public TabbedExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.add("Student", new StudentGUI());
                tabbedPane.add("Courses", new CourseGUI());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(tabbedPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class StudentGUI extends JPanel {

        public StudentGUI() {
            setLayout(new BorderLayout());

            JPanel top = new JPanel(new BorderLayout());
            top.setBackground(Color.BLUE);
            top.add(new JLabel("Top"));

            JPanel middle = new JPanel(new BorderLayout());
            middle.setBackground(Color.GREEN);
            middle.add(new JLabel("Middle"));

            JPanel bottom = new JPanel(new BorderLayout());
            bottom.setBackground(Color.CYAN);
            bottom.add(new JLabel("Bottom"));

            add(top, BorderLayout.NORTH);
            add(middle);
            add(bottom, BorderLayout.SOUTH);
        }

    }

    public class CourseGUI extends JPanel {

        public CourseGUI() {
            setLayout(new BorderLayout());

            JPanel top = new JPanel(new BorderLayout());
            top.setBackground(Color.RED);
            top.add(new JLabel("Top"));

            JPanel middle = new JPanel(new BorderLayout());
            middle.setBackground(Color.ORANGE);
            middle.add(new JLabel("Middle"));

            JPanel bottom = new JPanel(new BorderLayout());
            bottom.setBackground(Color.MAGENTA);
            bottom.add(new JLabel("Bottom"));

            add(top, BorderLayout.NORTH);
            add(middle);
            add(bottom, BorderLayout.SOUTH);
        }

    }
}