private JFrame getFrame(){
    return this;
}
...

textField.getDocument().addDocumentListener(new DocumentListener(){

    @Override
    public void insertUpdate(DocumentEvent e) {
        message = textField.getText();
        getFrame().repaint();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        message = textField.getText();
        getFrame().repaint();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // on change
    }

});