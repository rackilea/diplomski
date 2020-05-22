import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.text.*;

public class TestDigitsOnlySpinner {

    public static void main(String... args) {
        SwingUtilities.invokeLater((Runnable) new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("enter digit");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JSpinner jspinner = makeDigitsOnlySpinnerUsingDocumentFilter();
                frame.getContentPane().add(jspinner, BorderLayout.CENTER);
                frame.getContentPane().add(new JButton("just another widget"), BorderLayout.SOUTH);
                frame.pack();
                frame.setVisible(true);
            }

            private JSpinner makeDigitsOnlySpinner_BasicAttempt() {
                JSpinner spinner = new JSpinner(new SpinnerNumberModel());
                return spinner;
            }

            private JSpinner makeDigitsOnlySpinnerUsingDocumentFilter() {
                JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
                JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor) spinner.getEditor();
                final Document jsDoc = jsEditor.getTextField().getDocument();
                if (jsDoc instanceof PlainDocument) {
                    AbstractDocument doc = new PlainDocument() {

                        private static final long serialVersionUID = 1L;

                        @Override
                        public void setDocumentFilter(DocumentFilter filter) {
                            if (filter instanceof MyDocumentFilter) {
                                super.setDocumentFilter(filter);
                            }
                        }
                    };
                    doc.setDocumentFilter(new MyDocumentFilter());
                    jsEditor.getTextField().setDocument(doc);
                }
                return spinner;
            }
        });
    }

    private static class MyDocumentFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (stringContainsOnlyDigits(string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (stringContainsOnlyDigits(text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean stringContainsOnlyDigits(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private TestDigitsOnlySpinner() {
    }
}