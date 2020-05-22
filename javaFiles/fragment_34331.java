public class EndCycleTextAreaRenderer extends JTextPane implements TableCellRenderer {

    private final int maxNumberOfCharacters = 200;

    public EndCycleTextAreaRenderer() {
        setStyledDocument(new DefaultStyledDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if ((getLength() + str.length()) <= maxNumberOfCharacters) {
                    super.insertString(offs, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }
}