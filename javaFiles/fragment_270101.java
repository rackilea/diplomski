SignupButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {               
        String Username = "";
        String Password = "";
        String ConfirmPass = "";

        Username = UsernameTF.getText();
        Password = PasswordTF.getText();
        ConfirmPass = ConfirmPassTF.getText();

        if(Password.equals(ConfirmPass)) {
            PassErrorMsg.setVisible(false);

            // do database stuff here

        } else {
            // here clear fields and show an error message
            // consider incrementing an error count as well
        }
    }
});