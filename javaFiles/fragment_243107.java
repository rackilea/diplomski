public enum MyEnum
{
    A("a"),
    B("b"),

    private String value;
    MyEnum(String value){ this.value = value; }
    public String toString() { return this.value; }
}