import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class FilterDemo {

    public FilterDemo() {
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 300);
        frame.add(createFilteredField());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    private JTextField createFilteredField() {
        JTextField field = new JTextField(20);
        AbstractDocument document = (AbstractDocument) field.getDocument();
        final int maxCharacters = 10;
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offs, int length,
                    String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if (text.matches("^\\d+\\.?\\d*$")) {   //  "^[0-9]+[.]?[0-9]{0,}$"
                    super.replace(fb, offs, length, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }

            }

            @Override
            public void insertString(FilterBypass fb, int offs, String str,
                    AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if (text.matches("^\\d+\\.?\\d*$")) {
                    super.insertString(fb, offs, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FilterDemo();
            }
        });
    }
}