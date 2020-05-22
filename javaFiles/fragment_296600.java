enum Rank {
    DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    public int value() {
        return this.ordinal() + 2; // This will return 2 for DEUCE, 3 for THREE and so on..
    }
}