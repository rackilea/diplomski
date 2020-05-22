public class Config implements ServletContextListener {
    private static final String ATTRIBUTE_NAME = "config";
    private Properties config = new Properties();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new SomeRuntimeException("Loading config failed", e);
        }
        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP.
    }

    public static Config getInstance(ServletContext context) {
        return (Config) context.getAttribute(ATTRIBUTE_NAME);
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}