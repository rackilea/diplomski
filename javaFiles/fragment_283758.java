char[] deckColors = {'♦', '♠', '♣', '♥'};
short[] cardNum = {(short) 'A', (short) '2', (short) '3', (short) '4', (short) '5', (short) '6', (short) '7',
                   (short) '8', (short) '9', (short) 'T', (short) 'J', (short) 'Q', (short) 'K'};
int cardCount;

public Card[] getShuffledDeck() {

    Random r = new Random();


    Card[] deckCards = new Card[(deckColors.length * cardNum.length)];

    int cnt = 0;

    for (char c : deckColors) {
        for (short s : cardNum) {
            deckCards[cnt++] = new Card(c, s);
        }
    }

    Card[] shuffledDeck = new Card[deckCards.length];

    int addedCount = 0;


    while (addedCount < deckCards.length) {
        int tInt = r.nextInt((deckCards.length));

        Card c = deckCards[tInt];

        if (c != null) {

            shuffledDeck[addedCount++] = c;
            deckCards[tInt] = null;

        } else {

        }
    }

    return shuffledDeck;

}