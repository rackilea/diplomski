class ContextListenerImpl implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //can be empty for now
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext sc = sce.getServletContext();

        //... here you can create and initialize your HashMap

        //when map is ready add it as attribute to servlet context 
        sc.setAttribute("mySpecialMap", map);
    }
}