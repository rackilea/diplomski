List<Card> generateCardsForSuit(final Suit suit) {
    final List<Card> result = new ArrayList<>();
    for(Rank rank : Rank.values()) {
        result.add(new Card(rank, suit);
    }
    return result;
}