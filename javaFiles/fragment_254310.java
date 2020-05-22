public class AbstractWebApplicationInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Here we store ServletContext in some global static variable
        Global.servletContext = servletContext;
        ....
    }