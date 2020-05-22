public class Example {

    public static class Superclass {
        public void foo() {
            new Exception().printStackTrace();
        }
    }

    public static class Subclass extends Superclass {
        // nothing here
    }

    public static void main(String[] argv)
    throws Exception
    {
        Superclass s = new Subclass();
        s.foo();
    }
}