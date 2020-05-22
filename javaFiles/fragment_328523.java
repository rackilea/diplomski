boolean checkIfNumber(String s) {
    try {
        Integer.parseInt(s);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Enter a number!");
        return false;
    }
    return true;
}