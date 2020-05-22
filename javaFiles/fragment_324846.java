List<Card> deck = new ArrayList<Card>();

for (Suit s : Suit.values()) {
  for (Rank r : Rank.values()) {
    deck.add(new Card(r, s));
  }
}