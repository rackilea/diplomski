String[] btnNames = {"1", "2", "3", etc.};
JButton[] allBtns = new JButton[10];
for(int i = 0; i < 10; i++){
    allBtns[i] = new JButton(btnNames[i]);
    allBtns[i].addActionListener(this);
    //Using the previous actionPerformed
}