public class Config implements ServletContextListener {
    private static final String ATTRIBUTE_NAME = "config";
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        String databaseName = servletContext.getInitParameter("database.name");
        try {
            dataSource = (DataSource) new InitialContext().lookup(databaseName);
        } catch (NamingException e) {
            throw new RuntimeException("Config failed: datasource not found", e);
        }
        servletContext.setAttribute(ATTRIBUTE_NAME, this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP.
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public static Config getInstance(ServletContext servletContext) {
        return (Config) servletContext.getAttribute(ATTRIBUTE_NAME);
    }
}