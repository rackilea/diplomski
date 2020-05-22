public class MyClass
{
    /** Factory Method, only way to create a MyClass instance */
    public static MyClass create()
    {
        final MyClass instance = new MyClass();
        // initialize class however you need it
        return instance;
    }

    private MyClass()
    {
        // normal constructor, if no logic you still need this
        // to make sure it can only be created by the Factory Method
        super();
    }
}