...
int index = 0;   // <-- Add this line
for(int y = 30; y <= 140; y += 55) {
    for(int x = 30; x <= 140; x += 55) {
           // <-- remove the third for-loop
        buttonArray[index] = new JButton();
        buttonArray[index].setSize(50, 50);
        buttonArray[index].setLocation(x, y);
        buttonArray[index].addActionListener(this);
        super.add(buttonArray[index]);
        index++;   // <-- increment 'index'
    }  
}
...