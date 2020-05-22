@Singleton
private static class JPAInitializer {
    @Inject
    public JPAInitializer(final PersistService service) {
        service.start();
    }
}

@Override
protected void configure() {

    install(new JpaPersistModule("simpleRestApplication"));
    bind(JPAInitializer.class).asEagerSingleton();

    // another bindings...

}