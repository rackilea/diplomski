public class Card {
    public enum Suit {HEART, DIAMOND, CLUB, SPADE};
    public int getValue();         // Ace, Jack, Queen, King encoded as numbers also.
}

public class Deck {
    protected List<Card> cardList = new ArrayList();

    public void newDeck() {
       // clear & add 52 cards..
       Collections.shuffle( cardList);
    }
    public Card deal() {
        Card card = cardList.remove(0);
        return card;
    }
}