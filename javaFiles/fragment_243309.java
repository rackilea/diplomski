public class SomeService
    private FooFactory fooFactory;

    @Autowired
    public SomeService(FooFactory fooFactory) {
        this.fooFactory = fooFactory;
    }

    public void someMethod(String arg) {
        Foo foo = fooFactory.create(arg);
        ...
    }
    ....
}