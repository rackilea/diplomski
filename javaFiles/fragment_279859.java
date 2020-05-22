public enum MyEnum2 implements PropertiesSupplier {
    ENUM_2_CONST_1(Properties.of(9, "hey dude", 547.21578));

    private final Properties p;

    private MyEnum2(Properties p) {
        this.p = p;
    }

    @Override
    public Properties properties() {
        return this.p;
    }
}