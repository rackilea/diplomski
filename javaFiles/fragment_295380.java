enum Mode {
    HEAT(16), WIND(8), COOL(4), LOW(2), AUTO(1);
    private final int value;
    private Mode(int value) { this.value = value; }
    public int getValue() {return value;}
}

void someMethod() {
    // ...
    Mode mode = Mode.valueOf(str); // finds the named element. throws IllegalArgumentException
    firstPart += mode.getValue();
}