server = new Server(port);

ServletContextHandler context = new ServletContextHandler();
context.setResourceBase(htmlLoc);
context.setWelcomeFiles(new String[] { "index.html" });
server.setHandler(context);


JsonDataApiServlet dataServlet = new JsonDataApiServlet();
DefaultServlet staticServlet = new DefaultServlet();

context.addServlet(new ServletHolder(dataServlet), "/data/*");
context.addServlet(new ServletHolder(staticServlet), "/*");