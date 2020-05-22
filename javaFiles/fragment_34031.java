nameField.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            if(nameField.getText().length() > 0 && surNameField.getText().length() > 0)
                nextButton.setEnabled(true);
            else
                nextButton.setEnabled(false);
        }
    });