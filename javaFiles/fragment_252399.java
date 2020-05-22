@WebListener
public void Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("p", new Person());
    }

    // ...
}