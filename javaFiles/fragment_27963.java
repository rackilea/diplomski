boolean setToThree(JTextField target, JTextField first, JTextField second) {
    if ("1".equals(first.getText()) && "2".equals(second.getText()) {
        target.setText("3");
        return true;
    }
    return false;
}