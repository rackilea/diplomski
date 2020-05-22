public class BadClass {
    private String foo = "";
    private String foobar = "";

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public void setBar(String bar) {
        this.foobar = foo + bar;
    }

    public String toString() {
        return foobar;
    }
}