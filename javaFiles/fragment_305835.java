public Deck(int nbBox) {
    this.cardList = new LinkedList<>(); // <-- diamond operator

    for (int i = 0; i < nbBox; i++) {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                cardList.add(new Card(suit, value));
            }
        }
    }
}