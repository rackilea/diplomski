public enum CardValues {
    TWO(2),
    THREE(3); // ...

    private int value;

    private CardValues(final int v) {
        value = v;
    }

    public getValue() { return value;}
}