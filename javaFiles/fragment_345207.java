public class Main
{
    public static void main(final String[] argv)
    {
        final A a;

        a = new B();
        a.foo();
    }
}

abstract class A
{
    protected A()
    {
        bar(this);
    }

    private static void bar(final A a)
    {
        a.foo();
    }

    public abstract void foo();
}

class B extends A
{
    final String str;

    public B()
    {
        super();
        str = "Hello, World!";
    }

    public void foo()
    {
        System.out.println("str - " + str);
    }
}