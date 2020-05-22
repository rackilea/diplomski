static class MyObject {
    private int value;

    public MyObject(int value) {
        super();
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return System.identityHashCode(this) + " " + value;
    }
}