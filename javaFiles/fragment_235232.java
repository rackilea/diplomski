notepad.getDocument().addDocumentListener(new DocumentListener() {
    void insertUpdate(DocumentEvent e) {
        documentChanged = true;
    }

    void removeUpdate(DocumentEvent e) {
        documentChanged = true;
    }

    void changedUpdate(DocumentEvent e) {
        documentChanged = true;
    }

});