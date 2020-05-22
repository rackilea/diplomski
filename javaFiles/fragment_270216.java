public class FooExtension extends Foo {

    @Override
    public void foo(int number) {
        throw new UsupportedOperationException("Operation is not supported");
    }

    public void foo(String text) {
        super.foo(text.length());
    }
}