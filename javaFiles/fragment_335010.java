public class Test
{
    static {
        System.loadLibrary("Test");
    }

    public static void main(String [] args)
    {
        Test obj = new Test();
        obj.main();
    }

    void main()
    {
        f(null);
        f("not null");
        String s1 = null;
        f(s1);
        String s2 = n1();
        f(s2);
        n2();
    }

    public void f(String s)
    {
        if (s == null)
            System.out.println("null");
        else
            System.out.println(s);
    }

    native String n1();
    native void n2();
}