public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // other overrides
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{ new AuthenticationTokenFilter() };
    }
}