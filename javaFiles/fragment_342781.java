// You create a card...
JButton card = new JButton();
// You create an array of buttons
JButton[] deck = new JButton[9];

int xLoc=20, yLoc=5;

// You set the icon
card.setIcon(new ImageIcon("Back.jpg"));
// This is not a good idea...
card.setSize(200,250);
// JButton is visible by default...
card.setVisible(true);

// Start your loop...
for(int i=0; i<9;i++)
{
    // Assign the card reference to an element in the array...
    deck[i]=card;
    // Add the card, via the array to the component...here's your problem...
    pane.add(deck[i - 1]);