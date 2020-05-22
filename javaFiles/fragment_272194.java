public abstract class Bar {
    public foo() {
        // Do unconditional things...
        ...
        // Now subclass-specific things
        fooImpl();
    }

    protected void fooImpl();
}

public class FooBar extends Bar {
    @Override protected void fooImpl() {
        // ...
    }
}