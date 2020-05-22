enum Test {
    LETTER("1A");

    private String value;
    private Test(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isEqual(String value) { 
        return this.value.equals(value);
    }
}