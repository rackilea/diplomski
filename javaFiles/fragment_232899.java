@FunctionalInterface
interface Foo {
    void method1(int x);
    default void method2(int x) {
        // ...
    }
}