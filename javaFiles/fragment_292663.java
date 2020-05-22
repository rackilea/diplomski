public class ApplicationInitializer implements WebApplicationInitializer {

    //Called first when the application starts loading.
    public void onStartup(ServletContext servletContext)
            throws ServletException {
        System.out.println("Inside application initializer...");

        //Registering the class that incorporates the annotated DispatcherServlet configuration of spring
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(DispatcherConfig.class);

        //Adding the listener for the rootContext
        servletContext.addListener(new ContextLoaderListener(rootContext));

        //Registering the dispatcher servlet mappings.
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}