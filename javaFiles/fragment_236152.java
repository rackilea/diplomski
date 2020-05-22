public class AppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        //application is deployed
        //create your object and load it
        Inventory inventory = ...
        //get the application context
        ServletContext servletContext = sce.getServletContext();
        //store the object in application scope
        servletContext.setAttribute("inventory", inventory);
    }
    public void contextDestroyed(ServletContextEvent sce) {
        //application is undeployed
    }
}