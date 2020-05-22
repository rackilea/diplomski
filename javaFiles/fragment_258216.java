public interface AFactory
{
    public A create(int x, int y);
}

public class MyClass
{
    private final AFactory aFactory;

    public MyClass(AFactory aFactory) {
        this.aFactory = aFactory;
    }

    public void doSomething() {
        A a = aFactory.create(100, 101);
        // do something with the A ...
    }
}