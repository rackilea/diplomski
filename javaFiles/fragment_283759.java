Card[] cards;

int handRank;

public Hand(Card[] cards) {

    this.cards = new Card[3];

    //sort all cards
    if (cards[0].getNumber() > cards[1].getNumber()) {
        if (cards[0].getNumber() > cards[2].getNumber()) {
            //0 index is highest card
            this.cards[2] = cards[0];
            if (cards[2].getNumber() > cards[1].getNumber()) {
                //2 is second highest
                this.cards[1] = cards[2];
                this.cards[0] = cards[1];
            } else {
                //1 is second highest
                this.cards[1] = cards[1];
                this.cards[0] = cards[2];
            }

        } else {
            //2 index is highest

            this.cards[2] = cards[2];
            if (cards[0].getNumber() > cards[1].getNumber()) {
                //0 is second highest
                this.cards[1] = cards[0];
                this.cards[0] = cards[1];
            } else {
                //1 is second highest
                this.cards[1] = cards[1];
                this.cards[0] = cards[0];
            }
        }

    } else {
        if (cards[1].getNumber() > cards[2].getNumber()) {
            //1 index is highest card
            this.cards[2] = cards[1];
            if (cards[2].getNumber() > cards[0].getNumber()) {
                //2 is second highest
                this.cards[1] = cards[2];
                this.cards[0] = cards[0];
            } else {
                //0 is second highest
                this.cards[1] = cards[0];
                this.cards[0] = cards[2];
            }
        } else {
            //2 index is highest
            this.cards[2] = cards[2];
            if (cards[0].getNumber() > cards[1].getNumber()) {
                //0 is second highest
                this.cards[1] = cards[0];
                this.cards[0] = cards[1];
            } else {
                //1 is second highest
                this.cards[1] = cards[1];
                this.cards[0] = cards[0];
            }
        }
    }
}

public int getHandRank() {
    return handRank > 0 ? handRank : calculateHandRank();
}

public int calculateHandRank() {
    //assuming 3 cards dealt
    //Trial - ColorSeq - Seq - Color - Pair
    int[] powerOf2s = {1, 2, 4, 8, 16};
    return ((cards[0].getNumber() == cards[1].getNumber() && cards[1].getNumber() == cards[2].getNumber()) ? 1 : 0) * powerOf2s[4]
            + (((cards[2].getNumber() - 1 == cards[1].getNumber() && cards[1].getNumber() - 1 == cards[0].getNumber()) && (cards[2].getColor() == cards[1].getColor() && cards[1].getColor() == cards[0].getColor())) ? 1 : 0) * powerOf2s[3]
            + ((cards[2].getNumber() - 1 == cards[1].getNumber() && cards[1].getNumber() - 1 == cards[0].getNumber()) ? 1 : 0) * powerOf2s[2]
            + (((cards[2].getColor() == cards[1].getColor() && cards[1].getColor() == cards[0].getColor())) ? 1 : 0) * powerOf2s[1]
            + ((cards[0].getNumber() == cards[1].getNumber() || cards[1].getNumber() == cards[2].getNumber() || cards[0].getNumber() == cards[2].getNumber()) ? 1 : 0) * powerOf2s[0];

}