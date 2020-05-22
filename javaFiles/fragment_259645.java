class Foo
{
    private static int count;

    Foo()
    {
        count++;
    }

    static void printCount()
    {
        System.out.println(count);
    }
}

public class Test
{
    public static void main(String[] args)
    {
        Foo.printCount(); // 0
        Foo foo1 = new Foo();
        Foo foo2 = new Foo();
        Foo.printCount(); // 2        
    }
}