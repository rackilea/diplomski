for (k = 0; k < 13; k++) {
    for (l = 0; l < 4; l++) {
        tempA = rndm.get(k);
        tempB = suit.get(l);
        cardButton[k * 4 + l].setIcon(cardImage[tempA][tempB]);
        check[k * 4 + l] = Integer.toString(tempA+1);
    }
}