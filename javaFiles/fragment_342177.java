public class BinaryDocumentFilter extends DocumentFilter {

    @Override
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr)
            throws BadLocationException {
        StringBuilder buffer = new StringBuilder(text.length());
        for (int i = buffer.length() - 1; i >= 0; i--) {
        char ch = buffer.charAt(i);
        if (ch == '0' || ch == '1') {
            buffer.append(ch);
        }
        }
        super.insertString(fb, offset, buffer.toString(), attr);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb,
            int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (length > 0) {
        fb.remove(offset, length);
        }
        insertString(fb, offset, string, attr);
    }
}