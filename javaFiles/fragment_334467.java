public static enum AnEnum {
    CONSTANT1(_CONSTANT1), CONSTANT2(_CONSTANT2);

    private final String value;

    AnEnum(String aValue)
    {
        value = aValue;
    }

    public String getValue()
    {
        return value;
    }
}