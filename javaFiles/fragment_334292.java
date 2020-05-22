public enum Test {
    TEST1(0b00000001),
    TEST2(0b00000010),
    TEST3(0b00000011),
    TEST4(0b00000100);

    private final int value;

    private Test(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}