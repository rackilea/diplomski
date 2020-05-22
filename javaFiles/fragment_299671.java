public class AImpl {
    public B b;
    public AImpl(B b) {
        this.b = b;
    }
}

public interface B {
    // methods
}

public class BImpl implements B {
    public C c;
    public BImpl (C c) {
        this.c = c;
    }
}