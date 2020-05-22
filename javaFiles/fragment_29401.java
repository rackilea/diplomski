public abstract class BaseClass {
    protected int a, b;

    public abstract void A();
    public abstract void B();
}

public abstract class A extends BaseClass {
    protected int c;

    public abstract void C();
}

public class B extends BaseClass {
}