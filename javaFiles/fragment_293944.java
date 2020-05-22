void testDrawCards() {
    for (int i = 0; i < 52; i++) {
        int x = i % 13;
        int y = i / 13;
        cards[i].displayCard(x * 80, y * 80);
    }
 }