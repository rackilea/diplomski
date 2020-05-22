try {
    return Double.parseDouble(this.myTB.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog("Oops");
    return -1;
}