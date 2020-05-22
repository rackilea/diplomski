public class ServletGuiceConfig extends GuiceServletContextListener {
    protected static Injector injector;

    @Override
    protected Injector getInjector() {
        injector = Guice.createInjector(new ServiceConfig(), new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(LanguageService.class).to(LanguageServiceImpl.class);
            }
        });
        return injector;
    }
}