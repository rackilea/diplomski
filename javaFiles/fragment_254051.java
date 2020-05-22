public enum SomeEnum {

    ENUM_VALUE1("Some value1"),
    ENUM_VALUE2("Some value2"),
    ENUM_VALUE3("Some value3");

    private static final List<String> VALUES;

    private final String value;

    static {
        VALUES = new ArrayList<>();
        for (SomeEnum someEnum : SomeEnum.values()) {
            VALUES.add(someEnum.value);
        }
    }

    private SomeEnum(String value) {
        this.value = value;
    }

    public static List<String> getValues() {
        return Collections.unmodifiableList(VALUES);
    }

}