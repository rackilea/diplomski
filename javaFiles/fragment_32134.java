WebappContext webappContext = new WebappContext("grizzly web context", "");

    FilterRegistration testFilterReg = webappContext.addFilter("TestFilter", TestFilter.class);
    testFilterReg.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), "/*");

    ServletRegistration servletRegistration = webappContext.addServlet("Jersey", org.glassfish.jersey.servlet.ServletContainer.class);
    servletRegistration.addMapping("/myapp/*");
    servletRegistration.setInitParameter("jersey.config.server.provider.packages", "com.example");


    HttpServer server = HttpServer.createSimpleServer();
    webappContext.deploy(server);
    server.start();