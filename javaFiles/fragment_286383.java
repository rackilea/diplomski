class Counter {
    private int value;         // *** Private

    public Counter() {
        this.value = 0;
    }

    public int increment() {
        return ++this.value;
    }

    public int getValue() {    // *** Accessor
        return this.value;
    }
}