ServletContextHandler context = new ServletContextHandler();
context.setContextPath("/");
context.setBaseResource(Resource.newResource(webRootUri));

ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
holderPwd.setInitParameter("dirAllowed", "true");
holderPwd.setInitParameter("cacheControl", "max-age=3600,public");
context.addServlet(holderPwd,"/");
server.setHandler(context);