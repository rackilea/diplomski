final List<Card> deck = new LinkedList<>();
for (final CardType cardType : CardType.values()) {
    for (int i = 1; i <= 4; ++i) {
        final Card card = new Card(cardType, "CardName" + i);
        deck.add(card);
    }
}