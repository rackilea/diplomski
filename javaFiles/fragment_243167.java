public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void addCards(Card... cards) {
        this.cards.addAll(Arrays.asList(cards));
    }
}