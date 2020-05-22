register(new AbstractBinder() {
    @Override
    public void configure() {
      bindFactory(EMFFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
      bindFactory(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);
    }
});