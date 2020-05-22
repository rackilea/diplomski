public enum ConcreteClass {

    CONCRETE1(Concrete1.class),
    CONCRETE2(Concrete2.class);

    private final Class<? extends AbstractClass> clazz;

    private ConcreteClass(Class<? extends AbstractClass> clazz) {
        this.clazz = clazz;
    }

    public AbstractClass instantiate() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}