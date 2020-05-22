class Foo<T extends ClassBar> {
    private Foo() {} // private constructor

    public static <T extends ClassBarA> Foo<T> instance(T c) {
        return new Foo<T>();
    }

    public static <T extends ClassBarB> Foo<T> instance(T c) {
        return new Foo<T>();
    }

    public void foo(Class<T> c) {

    }

}