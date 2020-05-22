enum Rank {
    MAGE(0), PALADIN(1), PRIEST(2), ...;

    private int value;

    Rank(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }
}