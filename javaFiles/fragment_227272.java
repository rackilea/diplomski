public abstract class A {
    protected int propValue = 5;
    public int getProperty() {
        return propValue;
    }
}

public class B extends A {
    public B() {
        propValue = 13;
    }
}