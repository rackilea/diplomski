// You create an array of buttons
JButton[] deck = new JButton[9];

// Start your loop...
for(int i=0; i<9;i++)
{
    // Assign the card reference to an element in the array...
    deck[i]=new JButton();

    // You set the icon
    deck[i].setIcon(new ImageIcon("Back.jpg"));
    // This is not a good idea...
    deck[i].setSize(200,250);
    // JButton is visible by default...
    deck[i].setVisible(true);
    // Add the card, via the array to the component...here's your problem...
    pane.add(deck[i]);