JButton[] grid = new JButton[9];
this.setLayout(new GridLayout(3,3,1,1));
for(int i = 0; i < 9; i++) {
    JButton button = new JButton();
    ...//Attach event handlers, etc.
    this.add(button);
    grid.add(button);
}