static Factory<Facade> getFacadeFactory() {
    return new Factory<Facade>() {

        @Context
        ServiceLocator locator;

        @Override
        public Facade provide() {
            Facade facade = new Facade();
            locator.inject(facade);
            return facade;
        }

        @Override
        public void dispose(Facade facade) {}
    };
}

@Inject
public SystemSetup(ServiceLocator locator) {
    packages("foo.bar.rest");
    packages("org.glassfish.jersey.jackson");
    register(JacksonFeature.class);

    register(new AbstractBinder() {
        @Override
        protected void configure() {
            bindFactory(InjectFactory.getDaoFactory()).to(Dao.class);

            Factory<Facade> factory = InjectFactory.getFacadeFactory();
            locator.inject(factory);
            bindFactory(factory).to(Facade.class);
        }
    });
}