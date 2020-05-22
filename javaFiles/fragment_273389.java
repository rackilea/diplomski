public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        super.onStartup(servletContext);

        servletContext.addFilter("sessionLastAccessTimeUpdateFilter", new SessionLastAccessTimeUpdateFilter())
        .addMappingForUrlPatterns(null, true, "/*");

        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
        .addMappingForUrlPatterns(null, true, "/*");
    }
}