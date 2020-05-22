import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.print.attribute.AttributeSet;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class FilterTest {

    public static void main(String[] args) {
        new FilterTest();
    }

    public FilterTest() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextField field = new JTextField(10);
                ((AbstractDocument)field.getDocument()).setDocumentFilter(new SizeFilter(5));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(field);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class SizeFilter extends DocumentFilter {

        private int maxCharacters;

        public SizeFilter(int maxChars) {
            maxCharacters = maxChars;
        }

        public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
                        throws BadLocationException {

            if ((fb.getDocument().getLength() + str.length()) <= maxCharacters) {
                super.insertString(fb, offs, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
                        throws BadLocationException {

            if ((fb.getDocument().getLength() + str.length()
                            - length) <= maxCharacters) {
                super.replace(fb, offs, length, str, a);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }

}