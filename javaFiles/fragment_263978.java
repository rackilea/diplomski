Foo.java:
public class Foo
{
    public static final int SOMETHING = 1;
}

Bar.java:
public class Bar
{
    public static void main(String[] args)
    {
        System.out.println(Foo.SOMETHING);
    }
}