public class Q22213940
{
    public static void main(String[] args)
    {
        final B b = new B();
        final C c = new C();

        System.out.println("b = b.getInstance() " + b == b.getInstance());
        System.out.println("c = c.getInstance() " + c == c.getInstance());
    }

    public static class C extends A
    {
        @Override
        public C getInstance()
        {
            return this;
        }
    }

    public static class B extends A
    {
        @Override
        public B getInstance()
        {
            return this;
        }
    }

    public abstract static class A
    {
        public abstract <T> T getInstance();
    }
}