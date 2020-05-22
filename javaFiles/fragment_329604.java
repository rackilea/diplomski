import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FilterTryout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frm = new JFrame("Combo test");
                JComboBox<String> combo = new JComboBox<>(new String[] {"One", "Two", "Three"});
                combo.setEditor(new ComboEditor());
                combo.setEditable(true);
                frm.add(combo);
                frm.pack();
                frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }

    private static class ComboEditor extends BasicComboBoxEditor {
        @Override
        protected JTextField createEditorComponent() {
            JTextField fld = super.createEditorComponent();
            ((AbstractDocument) fld.getDocument()).setDocumentFilter(new NoDigitsFilter());
            return fld;
        }
    }

    private static class NoDigitsFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (isNoDigits(string)) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (isNoDigits(text)) {
                super.replace(fb, offset, length, text, attrs);
            }
        }

        private boolean isNoDigits(String text) {
            boolean noDigits = true;
            for (int i = 0; i < text.length() && noDigits; i++) {
                noDigits = !Character.isDigit(text.charAt(i));
            }
            return noDigits;
        }
    }
}