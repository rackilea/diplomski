public class Initalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/*", "*.html"};
    }

    @Override
    protected Filter[] getServletFilters() {
        UrlRewriteFilter urlRewriteFilter = new UrlRewriteFilter();
        /*
         * Add filter configuration here if necessary
         */
        return new Filter[] {urlRewriteFilter};
    }
}