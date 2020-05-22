final URL htmlDirectory = JerseyApplication.class.getResource("/html");

// TODO: Handle error if htmlDirectory == null

ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);
servletContextHandler.setContextPath("/");
servletContextHandler.setBaseResource(Resource.newResource(htmlDirectory));

DefaultServlet defaultServlet = new DefaultServlet();
ServletHolder holderPwd = new ServletHolder("default", defaultServlet);
// holderPwd.setInitParameter("resourceBase", htmlDirectory.getFile()); <-- not needed here
servletContextHandler.addServlet(holderPwd, "/"); // NOTE: MUST be "/" not "/*"!