@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ...
        initDispatcherServlet(servletContext, disps);
        ...
    } 


private void initDispatcherServlet(ServletContext servletContext, EnumSet<DispatcherType> disps) {

        // Using listener to be able to get the Dispatcher Servlet not yet initialized
        servletContext.addListener(new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent event) {
                try {
                    Map<String, ? extends ServletRegistration> servlets=null;
                    servlets = event.getServletContext().getServletRegistrations();
                    Set<String> keys = servlets.keySet();       

                    log.debug("Registred servlets : "+keys);

                    ServletRegistration dspSrvlt = servlets.get("dispatcherServlet");
                    if(dspSrvlt != null) {
                        Collection<String> maps = dspSrvlt.getMappings();
                        log.debug("Dispatcher servlet mapping size : "+maps.toArray().length);
                        log.debug("Servlet dispatcher mapping : "+maps);
                        if( !maps.contains("/*") ) {
                            log.debug("Adding /* for Spring Dispatcher servlet");
                            servlets.get("dispatcherServlet").addMapping("/*");
                        }
                    } else {
                        log.warn("Unable to change the Servlet Request dispatcher mapping to allow deployment with JBoss");
                    }
                } catch (Exception e) {
                    log.warn("Unable to change the Servlet Context to allow deployment with JBoss");
                }

            }

            @Override
            public void contextDestroyed(ServletContextEvent arg0) {
            }
        });

    }