package casino;

public class Card implements Comparable<Card> {
    public static final String[] SUIT = { "C", "D", "H", "S" };
    public static final String[] RANK = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };

    private int id;
    private int suit;
    private int numeral;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getNumeral() {
        return numeral;
    }

    public void setNumeral(int numeral) {
        this.numeral = numeral;
    }

    public Card(int cardNo) {
        assert cardNo >= 0;
        assert cardNo < 52;

        this.id = cardNo;
        this.suit = cardNo % 4;
        this.numeral = cardNo / 4;
    }

    public int compareTo(Card otherCard) {
        return Integer.compare(this.id, otherCard.id);
    }

    public String toString() {
        return String.format("%s%s", RANK[this.getNumeral()], SUIT[this.getSuit()]);
    }
}