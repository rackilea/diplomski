public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)  throws ServletException {

        AnnotationConfigWebApplicationContext context 
          = new AnnotationConfigWebApplicationContext();

        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.setInitParameter(
          "contextConfigLocation", "com.package.my");
    }
}