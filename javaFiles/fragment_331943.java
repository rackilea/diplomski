public class MyClass
{
    private static class Loader
    {
        public static final INSTANCE = new Foo();
    }

    Foo getInstance()
    {
        return Loader.INSTANCE;
    }
}