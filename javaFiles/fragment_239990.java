enum MyEnum {
    ATESTSTRING("A test String");

    private final String value;

    MyEnum(String value) { this.value = value; }

    @Override
    public String toString() {return value; }
}