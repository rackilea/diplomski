public enum Foo
{
    //  instances go here

    ;   // **** semicolon needed

    private String foo;
    private boolean isBarable;

    private Foo(String foo, boolean isBarable)
    {
        this.foo = foo;
        this.isBarable = isBarable;
    }
}