public enum Constants { 
    NAME_1("Value1"),
    NAME_2("Value2"),
    NAME_3("Value3");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}