JButton[] buttons = new JButton[9];
for (int i=0; i < buttons.length; i++) {
    buttons[i] = new JButton("X or O here");
    buttons[i].addActionListener(new MyAction());
    add(buttons[i]);
}