public class Test {

    static final char[] suits = {'♥', '♦', '♣', '♠'};
    static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    static class Card {
        final int suit;
        final int rank;

        Card(int s, int r) {
            suit = s;
            rank = r;
        }

        @Override
        public String toString() {
            return suits[suit] + ranks[rank]; // or however you want the cards to be printed
        }
    }


    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();
        for (int s = 0; s < suits.length; s++) {
            for (int r = 0; r < ranks.length; r++) {
                deck.add(new Card(s,r));
            }
        }
        Collections.shuffle(deck);
        List<Card> hand = deck.subList(0,5);

        Collections.sort(hand, Comparator.comparing(c -> c.rank));
        System.out.println("Your hand is: " + hand);

        System.out.println(value(hand));

    }

    static String value(List<Card> hand) {
        boolean straight = true;
        boolean flush = true;
        for (int i = 1; i < hand.size(); i++) {
            straight &= hand.get(i - 1).rank + 1 == hand.get(i).rank;
            flush &= hand.get(i - 1).suit == hand.get(i).suit;
        }

        if (straight && flush) {
            return "Straight Flush from " + hand.get(4);
        }

        List<Run> runs = findRuns(hand);
        runs.sort(Comparator.comparing(r -> -r.rank));
        runs.sort(Comparator.comparing(r -> -r.length));

        if (runs.get(0).length == 4) {
            return "Four of a Kind: " + runs;
        }

        if (runs.get(0).length == 3 && runs.get(1).length == 2) {
            return "Full House: " + runs;
        }

        if (straight) {
            return "Straight from " + hand.get(4);
        }

        if (runs.get(0).length == 3) {
            return "Three of a Kind: " + runs;
        }

        if (runs.get(1).length == 2) {
            return "Two pair: " + runs;
        }

        if (runs.get(0).length == 2) {
            return "Pair: " + runs;
        }

        return "High card: " + runs;
    }

    /** Represents {@code length} cards of rank {@code rank} */
    static class Run {
        int length;
        int rank;

        @Override
        public String toString() {
            return ranks[rank];
        }
    }

    static List<Run> findRuns(List<Card> hand) {
        List<Run> runs = new ArrayList<>();
        Run run = null;
        for (Card c : hand) {
            if (run != null && run.rank == c.rank) {
                run.length++;
            } else {
                run = new Run();
                runs.add(run);
                run.rank = c.rank;
                run.length = 1;
            }
        }
        return runs;
    }
}