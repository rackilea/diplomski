ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
servletContextHandler.setContextPath("/");
servletContextHandler.setWelcomeFiles(new String[] { "index.html" });
servletContextHandler.setResourceBase(webDir);
servletContextHandler.addServlet(DefaultServlet.class, "/");


ErrorPageErrorHandler errorHandler = new ErrorPageErrorHandler();
errorHandler.addErrorPage(404, "/"); // return root ... being index.html
servletContextHandler.setErrorHandler(errorHandler);