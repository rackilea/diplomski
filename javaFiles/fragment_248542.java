public class Deck {
    private List<Card> cards = new ArrayList<>();
    public Deck() {
        for (Suit suit: Suit.values()) {
            for (int rank = 2; rank <= ACE; rank ++) {
                cards.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(cards);  // Perhaps use your own Random too.
    }
    public synchronized Card deal() {
        Card dealt = cards.get(0);
        cards.remove(0);
        return dealt;
    }
}