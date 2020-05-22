class MyClass<T extends Enum<T> & MyInterface<T>>  {
    private T firstElement;
    private Class<T> enumType;

    @SuppressWarnings("unchecked")
    MyClass (Supplier<T> enumSupplier) {
        T actualEnum = enumSupplier.get();
        this.enumType = (Class<T>) actualEnum.getClass();
        this.firstElement = actualEnum.getFirst();
    }
}