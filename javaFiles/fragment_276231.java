public static class IntegerDocument extends PlainDocument {

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        StringBuilder sb = new StringBuilder(str.length());
        for (char c:str.toCharArray()) {
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
        }
        super.insertString(offs, sb.toString(), a);
    }
}