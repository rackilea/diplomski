import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.JTextComponent;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TextFieldHighlighter {

    public static void main(String[] args) {
        new TextFieldHighlighter();
    }

    public TextFieldHighlighter() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextField field = new JTextField(new DefaultStyledDocument(), null, 20);

                ((AbstractDocument) field.getDocument()).setDocumentFilter(new HighlightDocumentFilter(field));
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(field);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class HighlightDocumentFilter extends DocumentFilter {

        private DefaultHighlightPainter highlightPainter = new DefaultHighlightPainter(Color.YELLOW);
        private JTextComponent field;
        private SimpleAttributeSet background;

        public HighlightDocumentFilter(JTextComponent field) {
            this.field = field;
            background = new SimpleAttributeSet();
            StyleConstants.setBackground(background, Color.RED);
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            super.insertString(fb, offset, text, attr);
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

            String match = "and";

            super.replace(fb, offset, length, text, attrs);

            int startIndex = offset - match.length();
            if (startIndex >= 0) {

                String last = fb.getDocument().getText(startIndex, match.length()).trim();
                if (last.equalsIgnoreCase(match)) {

                    field.getHighlighter().addHighlight(startIndex, startIndex + match.length(), highlightPainter);

                }

            }
        }
    }
}