buttons = new JButton[9]; // You can use this to reset the board ;)
setLayout(new GridLayout(3, 3));
for (int index = 0; index < 9; index++) {
    JButton btn = new JButton(Integer.toString(index));
    buttons[index] = btn;
    btn.addActionListener(new ActionHandler(btn));
    add(btn);
}