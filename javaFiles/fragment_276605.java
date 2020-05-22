public class Config implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        String database = event.getServletContext().getInitParameter("DATABASE");
        // ...
    }

    // ...

}