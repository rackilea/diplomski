final JLabel test1 = new JLabel(myDeckOfCards.giveCardPlayer1().getImage());

ActionListener one = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Get 'anotherIcon' from somewhere, presumably from a similar
        // place to where you retrieved the initial icon
        test1.setIcon(anotherIcon);
    }
};

btn1.addActionListener(one);

panel2.add(lab1);
panel2.add(test1);
panel2.add(pn5);
panel2.add(pn1);
panel2.add(btn1);