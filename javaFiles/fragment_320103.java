public AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        //application is being deployed
        //register the "global" object here
        ServletContext sc = sce.getServletContext();
        MyGlobalClass globalObject = ...
        sc.setAttribute("globalObject", globalObject);
    }
    public void contextDestroyed(ServletContextEvent sce) {
        //application is being undeployed
    }
}