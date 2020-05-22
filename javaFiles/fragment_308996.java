public enum FooBarType {
    Foo,
    Bar;

    @javax.persistence.Converter
    public static class Converter implements AttributeConverter<FooBarType, String> {
        @Override
        public String convertToDatabaseColumn(FooBarType t) {
            return t.toString();
        }

        @Override
        public FooBarType convertToEntityAttribute(String s) {
            for (FooBarType value : FooBarType.values()) {
                if (value.name().equalsIgnoreCase(s)) {
                    return value;
                }
            }

            throw new IllegalArgumentException("Invalid value for enum: " + s);
        }
    }
}