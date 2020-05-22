public class Hand {
    private List<Card> cards;

    //constructor to create an empty hand
    public Hand() { 
        this.cards = new ArrayList<Card>();
    }

    //constructor to create an empty hand and add all provided cards to it
    public Hand(Card[] cards) {
        this();
        this.cards.addAll(Arrays.asList(cards));
    }

    //constructor to create an empty hand and add all cards in the provided hand
    public Hand(Hand hand) {
        this();
        this.cards.addAll(hand.getCards());
    }
}