JTextField myTextField = new JTextField();
myTextField.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent fe) {
        myTextField.setForeground(Color.RED);
    }

    @Override
    public void focusLost(FocusEvent fe) {
        myTextField.setForeground(Color.GREEN);
    }
});