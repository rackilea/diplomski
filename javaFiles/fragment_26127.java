public abstract class MyAbstractClass {

    protected String greeting;

    public void run() {
        doSomething();
    }

    public abstract void doSomething();

    public abstract MyAbstractClass makeClass();

}

public class MyClass1 extends MyAbstractClass {

    public MyClass1() {
        this.greeting = "Hello, World!";
    }

    @Override
    public void doSomething() {
        System.out.println(greeting);
    }

    @Override
    public MyAbstractClass makeClass() {
        return new MyClass1();
    }

}