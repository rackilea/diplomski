for(Card card : this.cards) {
    if (card instanceof CardType1) {
        CardType1 card1 = (CardType1) card;
        // do something with the card1
    } else {
        CardType2 card2 = (CardType2) card;
        // do something with the card2
    }
 }