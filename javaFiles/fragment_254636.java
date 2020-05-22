class Foo {
    // nothing new:
    public interface FooFactory {
        Foo createFoo();
    }
    // new in Java 8:
    public static final FooFactory DEFAULT_FACTORY = Foo::new;
}