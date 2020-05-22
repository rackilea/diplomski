public abstract class SuperClass {
    abstract void abstractTest();
}

public class ClassForTesting extends SuperClass {
    @Override
    void abstractTest() {
        ...
    }

    public void publicMethod() {
        abstractTest() 
    }

}