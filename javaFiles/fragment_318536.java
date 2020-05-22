public final class Concat {
    private String foo;
    private String bar;

    Concat(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    String getResult() {
        return foo + bar;
    }

}