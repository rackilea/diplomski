class Foo 
{
    public static final Foo foo = new Foo();

    public static int x() { return 0; }
}

class AnotherClass
{
    void test() 
    {
        print(Foo.x());
    }
}