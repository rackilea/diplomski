public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        container.addListener(new ContextLoaderListener(context));
        context.register(ApplicationConfiguration.class);

        FilterRegistration filter = container.addFilter("wicket.myproject", WicketFilter.class);
        filter.setInitParameter("applicationClassName", WicketApplication.class.getName());
        filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        filter.addMappingForUrlPatterns(null, false, "/*");
    }

}