public final class ConcreteA extends AbstractA {
    private String foo;
    protected ConcreteA() {
    }
    public static final class Builder extends AbstractA.ABuilder<ConcreteA,Builder> {
        @Override protected ConcreteA getObject() {
            return new ConcreteA();
        }
        @Override protected Builder thisObject() {
            return this;
        }
        public Builder() {
        }
        public Builder withFoo(String foo) {
            object.foo = foo;
            return this;
        }
    }
}