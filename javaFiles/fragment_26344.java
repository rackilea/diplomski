textField.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    void changedUpdate(DocumentEvent e) {}
    @Override
    void insertUpdate(DocumentEvent e) {
        // Your counter method
        updateCount();
    }
    @Override
    void removeUpdate(DocumentEvent e) {
        updateCount();
    }
});