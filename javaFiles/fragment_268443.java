class MyIntegerBounded {
    private int value;
    private int bound;

    public MyIntegerBounded(int value, int bound) {
        this.value = value;
        this.bound = bound;
    }

    int get() {
        return value;
    }

    void increment() {
        add(1);
    }

    void add(int toAdd) {
        value = (value + toAdd) % bound;
    }
}