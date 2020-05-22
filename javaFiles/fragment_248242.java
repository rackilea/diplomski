import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class TestSpinner01 {

    public static void main(String[] args) {
        new TestSpinner01();
    }

    public TestSpinner01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JSpinner spinnerUpDown = new JSpinner();
                spinnerUpDown.setModel(new SpinnerNumberModel(0, 0, 1000, 10));
                spinnerUpDown.setEditor(new JSpinner.NumberEditor(spinnerUpDown, "0000"));
                System.out.println(spinnerUpDown.getEditor());


                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(spinnerUpDown);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                PlainDocument doc = new PlainDocument() {
                    private TestFilter filter;
                    @Override
                    public DocumentFilter getDocumentFilter() {
                        if (filter == null) {
                            filter = new TestFilter();
                        }
                        return filter;
                    }

                };

                JTextComponent txt = ((JSpinner.DefaultEditor) spinnerUpDown.getEditor()).getTextField();
                txt.setDocument(doc);
            }
        });
    }

    public class TestFilter extends DocumentFilter {

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
            System.out.println("remove");
            super.remove(fb, offset, length);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            System.out.println("insert");
            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            System.out.println("Replace...");
            super.replace(fb, offset, length, text, attrs);
        }
    }
}