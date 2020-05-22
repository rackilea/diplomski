public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(new ContextLoaderListener(createWebAppContext()));
        addApacheCxfServlet(servletContext);
    }

    private void addApacheCxfServlet(ServletContext servletContext) {
        CXFServlet cxfServlet = new CXFServlet();

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("CXFServlet", cxfServlet);
        appServlet.setLoadOnStartup(1);

        Set<String> mappingConflicts = appServlet.addMapping(AppConfig.API_BASE);
    }

    private WebApplicationContext createWebAppContext() {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();

        // register all the config classes here
        appContext.register(AppConfig.class);
        return appContext;
    }

}