import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class TestLabelMirror {

    private JPanel mainPanel = new JPanel();
    private JTextField field = new JTextField(20);
    private JTextField field1 = new JTextField(20);
    private JFrame frame;

    public TestLabelMirror() {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            private void updateLabel(DocumentEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        String text = field.getText();
                        String text1 = field1.getText();

                        if (!text.isEmpty()) {
                            int p = Integer.parseInt(text);
                            int i = (p * 5);
                            String s = String.valueOf(i);
                            field1.setText(s);
                        } else {
                            field1.setText(null);
                        }

                    }

                });
            }
        });
        ((AbstractDocument) field.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }

            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException {
                fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
            }
        });

        mainPanel.setLayout(new GridLayout(1, 0, 10, 0));
        mainPanel.add(field);
        mainPanel.add(field1);
    }

    public JComponent getComponent() {
        return mainPanel;
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("TextLabelMirror");
        frame.getContentPane().add(new TestLabelMirror().getComponent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}