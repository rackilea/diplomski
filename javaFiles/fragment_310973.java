@Order(1)
public class DemoSecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    public DemoSecurityWebApplicationInitializer() {
        super(DataConfiguration.class, SecurityConfig.class);
    }

    @Override
    public void afterSpringSecurityFilterChain(ServletContext servletContext) {
        // Set the Jersey used property to it won't load a ContextLoaderListener
        servletContext.setInitParameter("contextConfigLocation", "NOOP");
    }
}