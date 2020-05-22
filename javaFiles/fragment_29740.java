public class AppServletContextListener implements ServletContextListener {
    private static Properties properties;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String cfgfile = servletContextEvent.getServletContext().getInitParameter("config_file");
        properties.load(new FileInputStream(cfgfile));
        //Some code..
        properties.getProperty("dbUser");
    }

    public static Properties getProperties(){
        return properties;
    }
}