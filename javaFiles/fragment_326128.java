public class GuiceConfig extends GuiceServletContextListener
{
    @Override
    protected Injector getInjector()
    {
        return Guice.createInjector(new JerseyServletModule()
        {
            @Override
            protected void configureServlets()
            {
                bind(MyResource.class);
                bind(AnotherResource.class);
                bind(MySingletonDao.class).to(ConcreteMySingletonDao.class);
                serve("/*").with(GuiceContainer.class);
            }
        });
    }
}