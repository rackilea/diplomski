import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestPopup {

    public static void main(String[] args) {
        new TestPopup();
    }

    public TestPopup() {
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

        private JButton show;

        public TestPane() {
            setLayout(new GridBagLayout());
            show = new JButton("...");
            show.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PopupWindow window = new PopupWindow();
                    window.show(show, 0, show.getHeight());
                }
            });
            add(show);
        }

    }

    public class SearchPane extends JPanel {

        private JList list;
        private JTextField search;

        public SearchPane() {
            setLayout(new BorderLayout());
            list = new JList();
            list.setPrototypeCellValue("This is just a test");
            list.setVisibleRowCount(20);
            search = new JTextField(10);
            add(new JScrollPane(list));
            add(search, BorderLayout.SOUTH);
        }

    }

    public class PopupWindow extends JFrame {

        private SearchPane searchPane;

        public PopupWindow() {
            setUndecorated(true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            addWindowFocusListener(new WindowFocusListener() {

                @Override
                public void windowGainedFocus(WindowEvent e) {
                }

                @Override
                public void windowLostFocus(WindowEvent e) {
                    dispose();
                }
            });
            searchPane = new SearchPane();
            add(searchPane);
            pack();
        }

        public void show(JComponent parent, int x, int y) {
            Point point = new Point(x, y);
            SwingUtilities.convertPointToScreen(point, parent);
            setLocation(point);
            setVisible(true);
        }

    }

}