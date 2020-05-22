public class Foo {

    protected void method() {
        System.out.println("In Foo.method()");
    }
}

public class FooWrapper extends Foo {

    private Foo foo;

    public FooWrapper(Foo foo) {
        this.foo = foo;
    }

    public void method() {
        try {
            Method m = foo.getClass().getDeclaredMethod("method", null);
            m.setAccessible(true);
            m.invoke(foo, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}