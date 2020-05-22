ArrayList<Card> deck = new ArrayList<>();

    for (int deckIndexTracker = 2; deckIndexTracker <= 14; deckIndexTracker++)
    {
        deck.add(new Card(deckIndexTracker, CardType.HEART));
        deck.add(new Card(deckIndexTracker, CardType.CLUB));
        deck.add(new Card(deckIndexTracker, CardType.SPADE));
        deck.add(new Card(deckIndexTracker, CardType.DIAMOND));
    }