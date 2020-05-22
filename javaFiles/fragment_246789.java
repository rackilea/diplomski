private int count;

desktop.add(createInternalFrame(++count));

private JInternalFrame createInternalFrame(int number) {
    JInternalFrame jif = new JInternalFrame(
        "F" + number, true, true, true, false);
    int topLeft = 25 * number;
    jif.add(new JTextField(String.valueOf(number), 8));
    jif.pack();
    jif.setLocation(topLeft, topLeft);
    jif.setVisible(true);
    return jif;
}