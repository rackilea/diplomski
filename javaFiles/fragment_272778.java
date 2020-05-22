public void contextInitialized(ServletContextEvent event) {
    this.contextLoader = createContextLoader();
    if (this.contextLoader == null) {
        this.contextLoader = this;
    }
    this.contextLoader.initWebApplicationContext(event.getServletContext());
}