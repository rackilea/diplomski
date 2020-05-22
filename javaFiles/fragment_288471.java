// Create deck
Card[] cards = new Card[52];
int i = 0;
for (int v = 2; v <= 14; v++)
    for (char s : "CDHS".toCharArray())
        cards[i++] = new Card(v, s);

// Shuffle
Collections.shuffle(Arrays.asList(cards));