public class FooAdapter implements FooOrBar {

    private final Foo foo;

    public FooAdapter(Foo foo) {
        this.foo = foo;
    }

    public String getName() {
        return foo.getName();
    }

    public void setName(String name) {
        foo.setName(name);
    }

}