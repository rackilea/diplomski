public class Cards {
    protected int rank;
    protected int suit;
    protected String[] sNames = {"Hearts", "Clubs", "Spades", "Diamonds"};
    protected String[] rNames = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Cards(int rank, int suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public String toString() {
        return ("Your card is: "+rNames[rank-1]+" of "+sNames[suit-1]);
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}