int level = 0;
if (containsUppercase(password)) {
    level++;
}
if (containsLowercase(password)) {
    level++;
}
if (containsNumbers(password)) {
    level++;
}

if (level <= 1) {
    JOptionPane.showMessageDialog(null, "Your password strength is WEAK. You must enter another password");
    passwordreenter = 0;
} else if (level == 2) {
    passwordreenter = JOptionPane.showConfirmDialog(null, "Your password strength is MEDIUM. Would you like to enter another password anyway?");
    System.out.println(passwordreenter);
} else if (level == 3) {
    JOptionPane.showMessageDialog(null, "Your password strength is STRONG. The program will now close");
    System.exit(0);
}