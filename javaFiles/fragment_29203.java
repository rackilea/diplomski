public static void LoginScreen(){
    // ............ code deleted to simplify things

    JTextField user = new JTextField(15);
    JTextField pass = new JTextField(15);

    // ..... code removed to simplify things

    LoginFrame.pack();
    LoginFrame.setVisible(true);

    UserN = user.getText();
    PassW = pass.getText();
}