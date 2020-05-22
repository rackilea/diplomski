class HangmanModel {
    public static final int MAX_VALUE = 9;
    private int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        setValue(getValue() + 1);
    }

    public void setValue(int value) {
        this.value = Math.min(value, MAX_VALUE);
        this.value = Math.max(this.value, 0);
    }    

}