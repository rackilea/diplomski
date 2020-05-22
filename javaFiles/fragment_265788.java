JTextField textField = new JTextField();
textField.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        if (text.matches("%\\d\\d"))
            return true;
        return false;
    }
});
textField.setText("%  ");