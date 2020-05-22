public class MyWebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Value("${request.dumper.active:false}")
    private Boolean dumpActive;

    @Bean
    private MyRequestDumperFilter myRequestDumperFilter() {
        MyRequestDumperFilter filter = new MyRequestDumperFilter();
        filter.setEnabled(dumpActive);
        return filter;
    }

    @Override
    protected String[] getServletMappings() {
        //..
        return new String[0];
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{myRequestDumperFilter()};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //..
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //..
        return new Class<?>[0];
    }
}