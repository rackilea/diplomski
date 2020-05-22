enum Suit {HEART, DIAMONDS, SPADES, CLUBS}
enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

public class Card {
    Rank rank;
    Suit suit;
    public Card (Rank r, Suit s) {rank = r; suit = s;} //public constructor
    @Override
    public String toString() {
        return rank.toString() + " " + suit.toString();
    }
}