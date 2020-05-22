class Number {

    private int value;

    public Number(int value) {
        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }

    public synchronized int changeData(int change) {
        value = change;
        return value;
    }
}