public static class IntegerWrapper {

    private int value;

    public IntegerWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public IntegerWrapper setValue(int value) {
        this.value = value;
        return this;
    }
}