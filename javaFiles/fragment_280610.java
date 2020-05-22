class Foo extends Enum<Foo> {
    private Foo() {/* calling Enum superconstructor */}
    public static final Foo CONSTANT = new Foo() { // no way to express an additional interface
        public String toString() {
            return name().toUpperCase();
        }
    };
}