public class Test {
    private int foo;

    public int getFoo() {
        return foo;
    }

    public synchronized void setFoo(int foo) {
        this.foo = foo;
    }
}