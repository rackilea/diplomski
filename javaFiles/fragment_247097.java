public class FooChild extends Foo {
    /**
     * @deprecated: This method should no longer be used and will throw an exception
     */
    @Override
    @Deprecated
    public void a() {
        String text = "The method a is no longer supported";
        throw new UnsupportedOperationException(text);
    }
}