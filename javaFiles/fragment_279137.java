public class WebServiceInitializer implements WebApplicationInitializer {

    private static final String ACTIVE_PROFILE = "production";

    /**
     * Registers and loads on startup MessageDispatcherServlet for the SOAP messages
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // @EnableWs, @Configuration, @ComponentScan
        context.setConfigLocation(WebServiceBeans.class.getName());
        context.getEnvironment().setActiveProfiles(ACTIVE_PROFILE);

        // use MessageDispatcherServlet instead of standard DispatcherServlet for SOAP messages
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setContextClass(AnnotationConfigWebApplicationContext.class);
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        // register MessageDispatcherServlet as Web Service entry point
        final ServletRegistration.Dynamic dispatcher = servletContext.addServlet("MessageDispatcherServlet",
                servlet);

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }