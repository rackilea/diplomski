public interface X {
    void addChangeListener();
}

public abstract class A {
    X a;

    protected abstract X newX();

    protected void setUp() {}

    @PostConstruct
    public void init() {
        a = newX();
        a.addChangeListener();
        setUp();
    }
}