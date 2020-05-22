class MyClass2<E extends Enum<E>> {
    private final Class<E> enumType;

    MyClass2(Class<E> enumType) {
        this.enumType = enumType;
    }
}