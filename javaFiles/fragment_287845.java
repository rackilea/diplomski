tf.getDocument().addDocumentListener(new DocumentListener() {
    public void changedUpdate(DocumentEvent e) {          // text was changed
        jl2.setText("Letters Used:    " + tf.getText());
    }
    public void removeUpdate(DocumentEvent e) {}          // text was deleted
    public void insertUpdate(DocumentEvent e) {}          // text was inserted
});