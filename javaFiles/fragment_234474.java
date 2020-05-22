formattedTextField.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent evt) {
            oldValue = formattedTextField.getText();
    }

    public void keyReleased(KeyEvent evt) {
        matcher = pattern.matcher(formattedTextField.getText());
        if(!matcher.matches()){
            formattedTextField.setText(oldValue);
        }
    }
}