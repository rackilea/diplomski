import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFocus {

    public static void main(String[] args) {
        new TestFocus();
    }

    public TestFocus() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            add(new JScrollPane(new JDynamicTextArea()));
            add(new JTextField(10));
        }

    }

    protected class JDynamicTextArea extends JTextArea implements FocusListener {

        public JDynamicTextArea() {
            super(10, 10);
            addFocusListener(this);
        }

        public void focusGained(FocusEvent e) {
            System.out.println("Focus gained");
        }

        public void focusLost(FocusEvent e) {
            System.out.println("Focus lost");
        }

    }

}