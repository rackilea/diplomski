interface Fooable {
    void foo();
}

...

<E extends Enum<E> & Fooable> void myMethod(Class<E> enumType) {
    E[] values = enumType.getEnumConstants();
    for (E value : values) {
        value.foo();
    }
}