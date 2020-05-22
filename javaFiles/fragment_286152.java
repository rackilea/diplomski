public abstract class CustomClass {
    public abstract void MyMethod();
}

public class Impl1 extends CustomClass {
    @Override
    public void MyMethod() {
        // Do something
    }
}

public class Impl2 extends CustomClass {
    @Override
    public void MyMethod() {
        // Do something else
    }
}