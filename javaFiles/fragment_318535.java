public class MyClass {
    private String foo;
    private String bar;

    MyClass(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String concatFooBar() {
        return new Concat(foo, bar).getResult();
    }

}