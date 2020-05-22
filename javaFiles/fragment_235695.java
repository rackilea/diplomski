int k, l, tempA = 0, tempB = 0;
    // create temporary variables
for (k = 0; k < 13; k++) {
    for (l = 0; l < 4; l++) {
        tempA = rndm.get(k);
        tempB = suit.get(l);
        // increment # and convert into string
        buttonNumber = buttonNumber+1;
        buttonName = Integer.toString(buttonNumber);
        // assign new button to the array
        cardButton[k * 4 + l] = new JButton(buttonName);
        // assign button image icon
        cardButton[k * 4 + l].setIcon(cardImage[tempA][tempB]);
        // assign value to the check variable
        check[k * 4 + l] = Integer.toString(tempA+1);
        // make button invisible for now
        cardButton[k * 4 + l].setVisible(false);
        // add the button to the board
        board.add(cardButton[k * 4 + l]);
    }
}