Library library = Library.create(new AbstractModule() {
    @Override
    protected void configure() {
        // recall requireBinding(SomeUserAPI.class) statement we wrote previously,
        // here we are "implementing" it
        bind(SomeUserAPI.class).to(SomeUserAPIImpl.class);
        // other bindings for your exposed interfaces
    }
});
MyAPIService service = library.myAPIService();