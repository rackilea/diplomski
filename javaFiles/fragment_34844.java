JTextField username = new JTextField("") ;
final int limit = 10;
username .setDocument(new PlainDocument(){
    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        if(getLength() + str.length() <= limit)
            super.insertString(offs, str, a);
    }
});