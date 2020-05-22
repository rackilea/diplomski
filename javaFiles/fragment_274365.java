class MyModule extends AbstractModule {
    @Override
    protected void configure() {

    A first = new B(1);
    B second = new B(2);


    bind(A.class)
        .annotatedWith(Names.named("first")).toInstance(first);

    bind(A.class)
        .annotatedWith(Names.named("second")).toInstance(second);
    }
}