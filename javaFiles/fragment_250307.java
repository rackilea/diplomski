public Dealer() {
    Deck deck = new Deck();
    for (Card card : deck.getCards()) {
        int suit = card.getSuit();
        int value = card.getValue();
    }
}