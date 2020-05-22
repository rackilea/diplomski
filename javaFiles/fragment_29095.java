int cardIndex = 0;
for (int suit = Card.SPADES; suit <= Card.CLUBS; suit++) {
    for (int i = 0; i < 13; i++) {
        cards[cardIndex++] = new Card(suit, i);
    }
}