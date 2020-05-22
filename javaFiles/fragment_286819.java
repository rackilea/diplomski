public enum SomeType
implements TypedValue {
    TYPE_A("aaa"),
    TYPE_B("bbb");

    private final String type;

    private SomeType(String type) { this.type = type; }

    @Override
    public String getType() {
        return type;
    }
}