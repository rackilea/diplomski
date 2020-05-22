final JLabel l = new JLabel(" ");

JTextField field = new JTextField();
field.getDocument().addDocumentListener(new DocumentListener() {

    @Override
    public void removeUpdate(DocumentEvent arg0) {
        validate(arg0);
    }

    @Override
    public void insertUpdate(DocumentEvent arg0) {
        validate(arg0);
    }

    @Override
    public void changedUpdate(DocumentEvent arg0) {
        validate(arg0);
    }

    private void validate(DocumentEvent arg0){
        Boolean b = arg0.getDocument().getLength() == 11;
        if (!b) {
            l.setText("error");
        } else {
            l.setText("accepted");
        }
    }
});