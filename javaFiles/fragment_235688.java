public enum Type {
    A("abc1", "desc1"),
    B("abc2", "desc2"),
    C("abc3", "desc3"),
    D("abc4", "desc4"),
    E("abc5", "desc5");

    private final String value;
    private final String description;

    private Type(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }
}

}