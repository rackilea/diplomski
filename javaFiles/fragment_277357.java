public class ReaderFoo extends Foo
{
    public static class FooReader implements Reader
    {
        @Override
        public void doit()
        {
            // functionality
        }
    }   

    public ReaderFoo ()
    {
        super(new FooReader());
    }
}