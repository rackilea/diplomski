public enum MyEnum {
    VALUE1("v1"),
    VALUE2("v2"),
    VALUE3("v3");

    private String displayValue;

    private MyEnum(string s) {
        this.displayValue = s;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}