private String translateSuit(int suit) {
    switch(suit) {
        case 0:
            return "Clubs";
        case 1:
            return "Spades";
        case 2:
            return "Hearts";
        case 3:
            return "Diamonds";
     }
     // All conditions exhausted, no sense in continuing:
     throw new IllegalArgumentException("invalid suit: " + suit);
}

private String translateRank(int card) {
    switch(card):
        case 1:
            return "Two";
        // fill in the rest here
    }
}

public String toString() {
    return translateRank(SUIT) + " of " + translateSuit(RANK)
           + " -- points: " + points;
}