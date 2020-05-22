UserInfoEditorPane userInfoPane = new UserInfoEditorPane();
switch (JOptionPane.showMessageDialog(null, userInfoPane, "User Info", JOptionPane.PLAIN_MESSAGE)) {
    case JOptionPane.OK_OPTION:
        Calculate secondwind = new Calculate(userInfoPane.getUserInfo());
        secondwind.setTitle("Calculate");       //Set title
        secondwind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close program
        secondwind.pack();
        secondwind.setLocationRelativeTo(null);
        secondwind.setVisible(true);
        break;
}