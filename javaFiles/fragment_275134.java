PlainDocument doc = new PlainDocument();
doc.setDocumentFilter(new DocumentFilter() {
    @Override
    public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) 
        throws BadLocationException 
    {
        fb.insertString(off, str.replaceAll("\\D++", ""), attr);  // remove non-digits
    } 
    @Override
    public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr) 
        throws BadLocationException 
    {
        fb.replace(off, len, str.replaceAll("\\D++", ""), attr);  // remove non-digits
    }
});

JTextField field = new JTextField();
field.setDocument(doc);