@Override
public void contextInitialized(ServletContextEvent sce) {
    try {
        loader.contextInitialized(sce);
    } catch (BeanCreationException e) {
        handle(e);
    }
}