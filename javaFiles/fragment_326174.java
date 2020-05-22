public class Initializer implements WebApplicationInitializer {

   public void onStartup(ServletContext servletContext)
        throws ServletException {
       AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

       ctx.scan("com.package.name");
       //the rest of initialization
    }

 }