class Counter {
    public int value;

    public Counter() {
        this.value = 0;
    }

    public int increment() {
        return ++this.value;
    }
}