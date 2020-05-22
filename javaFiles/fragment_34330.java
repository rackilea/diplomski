JTextPane textPane = new JTextPane(new DefaultStyledDocument() {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if ((getLength() + str.length()) <= maxNumberOfCharacters) {
            super.insertString(offs, str, a);
        }
        else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
});