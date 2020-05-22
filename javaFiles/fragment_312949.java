public interface I {
    void methodFromExternalAClass();
    void methodFromExternalBClass();
}

public class MyClass implements I {
    @Override
    public void methodFromExternalAClass() {
         new A().someMethod();
    }
    @Override
    public void methodFromExternalBClass() {
         new B().someMethod();
    }
}