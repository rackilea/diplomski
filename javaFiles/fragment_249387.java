class ContextListenerImpl implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //lets skip it for now
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc = sce.getServletContext();

        //read parameter from properties and add it to servlet context attributes
        sc.setAttribute("yourParameterName", "value");
    }

}