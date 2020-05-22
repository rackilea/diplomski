abstract class Handler<T, U extends Builder<T>> {
    public abstract void handle(U builder);
}

class FooHandler extends Handler<Foo, FooBuilder> {
    @Override
    public void handle(FooBuilder builder) {
        // do something
    }
}