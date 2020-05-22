public class WebfluxInitializer extends AbstractReactiveWebInitializer {

    private ServletContext servletContext;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        this.servletContext = servletContext;
        super.onStartup(servletContext);
    }

    @Override
    protected ApplicationContext createApplicationContext() {

        SpringApplicationBuilder builder = new SpringApplicationBuilder();

        StandardServletEnvironment environment = new StandardServletEnvironment();
        environment.initPropertySources(servletContext, null);

        builder.environment(environment);
        builder.sources(getConfigClasses());
        builder.web(WebApplicationType.NONE);
        builder.main(RbsApplication.class);

        return builder.build().run();
    }

    @Override
    protected Class<?>[] getConfigClasses() {
        return new Class[] { RbsApplication.class };
    }
}