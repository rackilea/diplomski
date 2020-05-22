public class FactoryInitialisingServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event) {
    }

    public void contextInitialized(ServletContextEvent event) {
        Properties properties = new Properties();
        ServletContext servletContext = event.getServletContext();
        Enumeration<?> keys = servletContext.getInitParameterNames();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = servletContext.getInitParameter(key);
            properties.setProperty(key, value);
        }
        Factory.setServletContextProperties(properties);
    }
}

public class Factory {

    static Properties _servletContextProperties = new Properties();

    public static void setServletContextProperties(Properties servletContextProperties) {
        _servletContextProperties = servletContextProperties;
    }
}