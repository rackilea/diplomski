@Override
public void preInit(ServletContext context, Set<Class<?>> classes) throws ServletException {
    final Class<? extends Application> applicationCls = getApplicationClass(classes);
    if (applicationCls != null) {
        final ApplicationPath appPath = applicationCls.getAnnotation(ApplicationPath.class);
        if (appPath == null) {
            LOGGER.warning("Application class is not annotated with ApplicationPath");
            return;
        }
        final String mapping = createMappingPath(appPath);
        addFilter(context, applicationCls, classes, mapping);
        // to stop Jersey servlet initializer from trying to register another servlet
        classes.remove(applicationCls);
    }
}

private static void addFilter(ServletContext context, Class<? extends Application> cls,
                              Set<Class<?>> classes, String mapping) {
    final ResourceConfig resourceConfig = ResourceConfig.forApplicationClass(cls, classes);
    final ServletContainer filter = new ServletContainer(resourceConfig);
    final FilterRegistration.Dynamic registration = context.addFilter(cls.getName(), filter);
    registration.addMappingForUrlPatterns(null, true, mapping);
    registration.setAsyncSupported(true);
}