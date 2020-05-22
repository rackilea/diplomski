public enum Rank {
    ACE("Ace", 1),
    TWO("2", 2),
    ...
    QUEEN("Queen", 10),
    KING("King", 10);

    private final String displayName;
    private final int value;

    protected Rank(String displayName, int value) {
        this.displayName = displayName;
        this.value = value;
    }

    public String displayName() {
        return displayName;
    }

    public int value() {
        return value;
    }
}