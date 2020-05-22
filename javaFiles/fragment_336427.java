deg.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {
        convert();
    }
    public void removeUpdate(DocumentEvent e) {
        convert();
    }
    public void insertUpdate(DocumentEvent e) {
        convert();
    }
});