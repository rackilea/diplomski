firstTextField.setFocusable(false);
firstTextField.setEditable(false);

secondTextField.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = secondTextField.getText();

        // here check the text String and if incorrect
        // call setText(...) on the firstTextField
    }
});