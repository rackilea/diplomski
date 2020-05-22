public class Test
{
    private Foo foo1;
    private Foo foo2;
}

public class Foo
{
    private Bar bar;
    private Object a;
}

public class Bar
{
    @MyAnnotation
    private List list;
}