txtUsername.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            updateOKButton();
        }
    });


@Override
protected void createButtonsForButtonBar(Composite parent) {
     okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
     createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
     okButton.setEnabled(false);
}


private void updateOKButton() {
    if(newUser){    
        if(txtUsername.getText() == null || txtUsername.getText().isEmpty()){
            this.setMessage("Username can not be empty!");
            okButton.setEnabled(false);
        }
        else if(txtPassword.getText().isEmpty() && txtPassword_1.getText().isEmpty()){
            this.setMessage("Passwords cannot be null!");
            okButton.setEnabled(false);
        }
        else if (!(txtPassword.getText().equals(txtPassword_1.getText()))) {
            this.setMessage("Password do not match!");
            okButton.setEnabled(false);     
        }else {
            this.setMessage(null);
            okButton.setEnabled(true);
        }
    }
    else{
        if(txtUsername.getText() == null || txtUsername.getText().isEmpty()){
            this.setMessage("Username can not be empty!");
            okButton.setEnabled(false);
        }
        else {
            this.setMessage(null);
            okButton.setEnabled(true);
        }
    }
}