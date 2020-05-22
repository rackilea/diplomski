public enum Example {
    A(1),
    B(2)
    ....

    private final int val;

    public Example (int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }
}