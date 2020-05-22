enum Suit {HEART, DIAMONDS, SPADES, CLUBS}
enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
class Card {
   public Rank rank;
   public Suit suit;

   public Card (Rank r, Suit s) {
     rank = r; suit = s;
   }
}