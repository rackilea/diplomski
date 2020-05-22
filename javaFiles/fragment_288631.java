public abstract class Foo
{
    protected Foo(String someString)
    {
        //Important Stuff Here
    }
}

public class Bar : Foo
{
    public Bar(String someString, Int32 myInt): base(someString)
    {
        //Let's the base class do it's thing
        // while extending behavior
    }
}