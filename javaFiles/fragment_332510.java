String pwd;
do {
    pwd = JOptionPane.showInputDialog("Password please:");
} while (pwd != null && !pwd.equals("qwerty"));
if (pwd == null) {
    JOptionPane.showMessageDialog(null, "You pressed cancel");
} else {
    JOptionPane.showMessageDialog(null, "Password is correct");
}