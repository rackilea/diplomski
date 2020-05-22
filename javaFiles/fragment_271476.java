private interface Foo
{
    void bar(final List<String> list);
}

private static final class X
{
    private final Foo foo;

    X(final Foo foo)
    {
        this.foo = foo;
    }

    void invokeBar()
    {
        // Note: using Guava's Lists here
        final List<String> list = Lists.newArrayList("a", "b", "c");
        foo.bar(list);
        list.clear();
    }
}