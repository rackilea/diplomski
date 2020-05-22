public class FooFactory {
    public static Foo createFoo(...) {
        Foo foo = new FooImpl(...);
        foo = Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[] { Foo.class },
                new FooInvocationHandler(foo));
        return foo;
    }
}