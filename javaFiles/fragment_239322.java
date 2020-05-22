class MyModule extends AbstractModule() {
    @Override
    protected void configure() {
        // ...
    }

    @Provides
    @Inject
    public List<Foo> foos(OneFoo one, TwoFoo two) {
        return Arrays.asList(one, two);
    }
}