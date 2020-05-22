public enum ConcreteClass {

    CONCRETE1(Concrete1::new),
    CONCRETE2(Concrete2::new);

    private final Supplier<AbstractClass> supplier;

    private ConcreteClass(Supplier<AbstractClass> supplier) {
        this.supplier = supplier;
    }

    public AbstractClass instantiate(){
        return supplier.get();
    }
}