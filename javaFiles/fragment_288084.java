while (x < 28) {
    gBC.gridx = z % 10;
    gBC.gridy = z / 10;
    JButton button = new JButton(chars[z]);
    pane.add(button, gBC);
    button.addActionListener(this);
    button.setActionCommand(chars[z]);
    x++;
    z++;
}