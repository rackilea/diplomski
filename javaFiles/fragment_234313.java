buttons = new JButton[24];
for (int i=0; i<24; i++) {
    buttons[i] = new JButton();
    buttons[i].setActionListener(this);
    buttons[i].setText("Hatch "+(i+1));
    buttons[i].setVisible(true);
    this.add(buttons[i]);
}