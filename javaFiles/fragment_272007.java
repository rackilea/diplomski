public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.scan("com.spring");
        rootContext.setConfigLocations(new String[]{"com.spring.config.WebAppContextConfig", "com.spring.config.AppConfig"});
        // Manages the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Declare dispatcher servlet. Handles requests into the application
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
                new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

}