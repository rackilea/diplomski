public class DeckOfCards {
    private Cards[] deck;
    private int cardHold;

    public DeckOfCards() {
        deck = new Cards[52];
        int n = 0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                deck[n] = new Cards(i, j);
                n = n+1;
            }
        }
        cardHold = -1;
    }

    public void shuffle() {
        int i = 0;
        while (i < 52) {
            int rando = (int) (5.0*(Math.random()));
            Cards temp = deck[rando];
            deck[rando] = deck[i];
            deck[i] = temp;
            i++;
        }
    }

    public Cards deal() {
        return (hasMoreCards() ? deck[++cardHold] : null);
    }

    public boolean hasMoreCards() {
        return (cardHold != 0);
    }

    public static void main(String[] args) {
        DeckOfCards deck2 = new DeckOfCards();
        deck2.shuffle();
        for (int i = 0; i < 52; i++)
            System.out.println(deck2.deal());
    }
}