protected void configure() {
    bind(new TypeLiteral<List<Foo>>() {})
       .toProvider(FooListProvider.class);
}

static class FooListProvider implements Provider<List<Foo>> {
    @Inject
    Provider<OneFoo> one;
    @Inject
    Provider<TwoFoo> two;

    public List<Foo> get() {
        return Arrays.asList(one.get(), two.get());
    }
}