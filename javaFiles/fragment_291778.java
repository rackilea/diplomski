class SomeClass {
    private int someValue;
    private String someString;

    public SomeClass(int someValue, String someString) {
        this.someValue = someValue;
        this.someString = someString;
    }

    public int someValue() {
        return this.someValue;
    }

    public String someString() {
        return this.someString;
    }

    public String toString() {
        return someValue + ": " + someString;
    }

}