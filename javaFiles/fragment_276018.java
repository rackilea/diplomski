public class Hand {
    private final Card[] cards;

    public Hand(Card[] cards) {
        this.cards = cards;
    }

    /**
     * Looks through each Card in the hand array and
     * adds its points (if it has any) to a sum.
     * @return the sum of the hand
    */
    public int countHighCardPoints() {
        int points = 0;
        for (Card card : cards) {
            points += card.getPoints();
        }
        return points;
    }

    /**
     * Count the number of Cards in each suit:
     * a suit with 3 cards or more counts for zero points
     * a suit with 2 cards counts one point (this is called a doubleton)
     * a suit with 1 card counts 2 points (this is called a singleton)
     * a suit with 0 cards counts 3 points (this is called a void)
     * @return the sum of the points
    */
    public int countDistributionPoints() {
        int clubs = 0;
        int diamonds = 0;
        int spades = 0;
        int hearts = 0;

        for (Card card : cards) {
            switch (card.getSuit()) {
                case CLUBS:
                    clubs++;
                    break;
                case DIAMONDS:
                    diamonds++;
                    break;
                case SPADES:
                    spades++;
                    break;
                case HEARTS:
                    hearts++;
                    break;
            }
        }

        final int result;
        if (clubs >= 3 || diamonds >= 3 || spades >= 3 || hearts >= 3) {
            result = 0;
        }
        else if (clubs == 2 || diamonds == 2 || spades == 2 || hearts == 2) {
            result = 1;
        }
        else if (clubs == 1 || diamonds == 1 || spades == 1 || hearts == 1) {
            result = 2;
        }
        else {
            result = 3;
        }

        return result;
    }

    public String toString() {
        String club = "";
        String diamond = "";
        String heart = "";
        String spade = "";

        for (Card card : cards) {
            switch (card.getSuit()) {
            case CLUBS:
                club.append(card.toString().replace(",", " "));
                break;
            case DIAMONDS:
                diamond.append(card.toString().replace(",", " "));
                break;
            case HEARTS:
                heart.append(card.toString().replace(",", " "));
                break;
            case SPADES:
                spade.append(card.toString().replace(",", " "));
                break;
        }
    }

    //Concatenates all of the string values of the clubs, diamonds, hearts, and spades into one string.
    return club + "\n" + diamond + "\n" + heart + "\n" + spade;
}