public enum Foo
{
    BAR("bar", true), BAZ("baz", false) ;

    private String foo;
    private boolean isBarable;

    private Foo(String foo, boolean isBarable)
    {
        this.foo = foo;
        this.isBarable = isBarable;
    }
}