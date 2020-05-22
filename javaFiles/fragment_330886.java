// will compile in Java 8 only
interface Foo {
    default void foo() {
        System.out.println("Default foo implementation");
    }
}