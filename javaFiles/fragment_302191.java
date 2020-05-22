....
 //Create the "cards".
    JPanel card1 = new JPanel();
    card1.add(new JButton("Button 1"));

    JPanel card2 = new JPanel();
    card2.add(new JTextField("TextField", 20));

    //Create the panel that contains the "cards".
    cards = new JPanel(new CardLayout());
    cards.add(card1, BUTTONPANEL);
    cards.add(card2, TEXTPANEL);