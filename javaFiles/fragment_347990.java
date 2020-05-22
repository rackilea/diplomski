public static class FacadeFactory implements Factory<Facade> {

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
}

register(new AbstractBinder() {
    @Override
    protected void configure() {
        bindFactory(InjectFactory.getDaoFactory()).to(Dao.class);
        bindFactory(InjectFactory.FacadeFactory.class).to(Facade.class);
    }
});