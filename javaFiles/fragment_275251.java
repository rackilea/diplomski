public enum MyEnum {
    ZERO(0), ONE(1), TWO(2);

    private int mapping;

    MyEnum(int mapping) {
        this.mapping = mapping;
    }

    public int getMapping() {
        return mapping;
    }

}