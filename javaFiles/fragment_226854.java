public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringMvcConfig.class, WebSecurityConfiguration.class };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    // Removed filter registering from here (Mistake 2)
}