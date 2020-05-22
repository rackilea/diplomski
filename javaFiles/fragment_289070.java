//action listeners for Login in button and menu item
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fName = jtfFname.getText();
            String lName = jtfLname.getText();
            String email = jtfEmail.getText();
            String address = jtfAddress1.getText();
            String username = jtfUsername.getText();
            String password = jtfPassword.getText();

            Create(fName , lName, email, address, username, password);
        }
    });