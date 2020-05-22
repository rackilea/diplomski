public class Card {

    private int suit;
    private int faceValue;

    public Card (int suit, int faceValue) {
        setSuit(suit);
        setFaceValue(faceValue);
    }

    int getFaceValue () {
        return faceValue;
    }

    void setFaceValue (int faceValue) {
        this.faceValue = faceValue;
    }

    int getSuit () {
        return suit;
    }

    void setSuit (int suit) {
        this.suit = suit;
    }

    public static void main (String[] args) {
        Card card = new Card(1, 4);

        System.out.print(card.getFaceValue());
        // Suit values into strings for Hearts,Spades,Clubs, Diamonds
        if (card.getSuit() == 1) {
             System.out.println(" of Hearts");
        } else if (card.getSuit() == 2) {
            System.out.println(" of Spades");
        } else if (card.getSuit() == 3) {
            System.out.println(" of Clubs");
        } else if (card.getSuit() == 4) {
            System.out.println(" of Diamonds");
        }
    }
}