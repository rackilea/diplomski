private int failedAttempts = 0;    

public void tryLogin() {
    final String username = jTextField1.getText();
    final String password = jPasswordField1.getText();

    // if (failedAttempts >= 3) ...

    if (loginOK(username, password)) {
        jTextField1.setText("");
        jPasswordField1.setText("");
        this.setVisible(false);
        new FrontPage().setVisible(true);
    }
    else {
        if (++failedAttempts >= 3) {
            JOptionPane.showMessageDialog(null, "Too many errors. bye.");
            System.exit(0); // or something
        }

        JOptionPane.showMessageDialog(null, "Information invalid. Please try again.");
        this.setVisible(false);
    }
}

public boolean isLoginOK(String username, String password) {
    for (int i=0; i<loginid.length; i++)
        if (username.equals(loginid[i]) && password.equals(password[i]))
            return true;

    return false;
}