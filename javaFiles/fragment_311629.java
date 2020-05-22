class Main {

    public static void main(String[] args) {
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "jack", "queen", "king", "ace" };
        String[] suits = { "spades", "diamonds", "clubs", "hearts" };
        int[] pointValues = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
        deck(ranks, suits, pointValues);
    }

    public static void deck(String[] ranks, String[] suits, int[] values) {
        List<Card> cards = new ArrayList<Card>();
        for (int j = 0; j < ranks.length; j++) {
            for (String suitString : suits) {
                cards.add(new Card(ranks[j], suitString, values[j]));
            }
        }
        System.out.println(cards.size());
    }
}

class Card {

    String rank;
    String suit;
    int value;

    public Card(String rank, String suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}