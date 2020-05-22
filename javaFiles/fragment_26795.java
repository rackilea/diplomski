// Our object we want to create
class Foo {
    private final Dependency1 d1;
    private final Dependency2 d2;

    public Foo(Dependency1 d1, Dependency2 d2){
        this.d1 = d1;
        this.d2 = d2;
    }

    // methods of foo
}

// our factory for the object
@Component
class FooFactory implements Factory<Foo>{
    private final Dependency1 d1;
    private final Dependency2 d2;

    @Autowired
    public FooFactory(Dependency1 d1, Dependency2 d2){
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public Foo create(){
        return new Foo(d1, d2);
    }
}