public enum MyEnum {

    Alpha,
    Bravo,
    Charlie {
        @Override
        public MyEnum next() {
            return null; // see below for options for this line
        };
    };

    public MyEnum next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    }
}