class Card<T extends Enum<T> & Rank> {

    private final T rank;

    public Card(T rank) {
        this.rank = rank;
    }

    public int getRankOrdinal() {
        return rank.ordinal();
    }

    public int getRankValue() {
        return rank.getValue();
    }
}

interface Rank {
    public int getValue();
}

enum BlackJackRank implements Rank {

    ACE(1);

    private final int value;

    private BlackJackRank(int value) {
        this.value = value;
    }
    @Override public int getValue() {
        return value;
    }
}