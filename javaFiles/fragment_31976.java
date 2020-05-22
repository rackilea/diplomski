public class Scratch
{
    public static abstract class A
    {
        public A( int i ) {}
    }

    public static class B extends A
    {
        private B() { super(0); };
    }
}