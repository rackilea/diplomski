while(adminLogIn) {
    System.out.println('\u000C');
    System.out.println("Enter Administrator Credentials: ");
    String adminusername = "admin";
    String adminpassword = "admin123";
    TimeUnit.SECONDS.sleep(1);
  JTextField usernameInput = new JTextField(15);
  JTextField passwordInput = new JPasswordField(15);

  JPanel myPanel = new JPanel();
  myPanel.add(new JLabel("Username: "));
  myPanel.add(usernameInput);
  myPanel.add(Box.createHorizontalStrut(15)); // a spacer
  myPanel.add(new JLabel("Password: "));
  myPanel.add(passwordInput);
  int result = JOptionPane.showConfirmDialog(null, myPanel, 
           "Administrator Login", JOptionPane.OK_CANCEL_OPTION);
    if (usernameInput.getText().equals(adminusername) && (passwordInput.getText().equals(adminpassword))) {
        System.out.println("Logging In...");
        TimeUnit.SECONDS.sleep(3);
        adminLogIn = false;
    } else {
        System.out.println("Wrong Username/Password. Try Again.");
        attempts++;
    }
    if (attempts == 3) {
        System.out.println("Login Failed. Locking Out User...");
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }
}