public class Base
{
    public final void doIt()
    {
        System.out.println("In Base.doIt()");
    }
}

public class Child extends Base
{
    public void doIt() // compiler error: Cannot overload the final method from Base
    {
        System.out.println("In Child.doIt()");
    }
}