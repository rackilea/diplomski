System.out.println("\n Cards on table");
List<Card> cards = deck.getCards();
Collections.sort(cards);
for (Card c: cards) {
    System.out.print((format("%10s","\033[F[ " + c.getOneSpecificNumber())+ " ]"));
}