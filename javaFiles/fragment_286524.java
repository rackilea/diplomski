public interface C {
    void doSomething();
}

public class A implements C {
    @Override
    public void doSomething() {
    }
}

public class B implements C {
    @Override
    public void doSomething() {
    }
}

public class Test {
    public C obj;

    obj = new A(); // or new B()

    obj.doSomething();
}