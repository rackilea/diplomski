public class BetterClass {
    private String foo = "";
    private String foobar = "";

    public BetterClass(String foo, String bar) {
        this.foo = foo;
        this.foobar = foo + bar;
    }

    public String toString() {
        return foobar;
    }
}