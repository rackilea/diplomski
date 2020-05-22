public enum MyEnum1 implements PropertiesSupplier {
    ENUM_1_CONST_1(Properties.of(1, "hello", 0.123)), 
    ENUM_1_CONST_2(Properties.of(2, "goodbye", 7.54));

    private final Properties p;

    private MyEnum1(Properties p) {
        this.p = p;
    }

    @Override
    public Properties properties() {
        return this.p;
    }
}