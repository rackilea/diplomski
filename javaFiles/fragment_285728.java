public static void main(final String[] args) {
    final JFrame frame = new JFrame("Test");
    final JLabel label = new JLabel();
    frame.add(label);
    frame.setSize(100, 30);
    frame.setVisible(true);
    checkDictionary(label);
}

public static int checkDictionary(final JLabel label) {
    for (final String s : rf.openFile()) {
        label.setText("Testing: [" + s + "]");
        if (password.equalsIgnoreCase(s)) {
            return 1;
        }
    }
    return -1;
}