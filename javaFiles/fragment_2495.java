public class Bar extends AbstractBar{    
    private final Foo foo;

    private Bar(Foo foo) {
        super(foo);
        this.foo = foo;
    }

    public Bar(){
        this(new Foo(bar));
    }
}