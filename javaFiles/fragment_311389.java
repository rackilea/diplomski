String str = "123";
if (str.matches("\\d+")) {
    JOptionPane.showMessageDialog(null, "Degit");
} else if (str.matches("[-+*/]")) {
    JOptionPane.showMessageDialog(null, "arithmetic operator( + - * /)");
}else{
    JOptionPane.showMessageDialog(null, "Incorrect input");
}