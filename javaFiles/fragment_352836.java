Restlet myRestlet = ...
ServletContextHandler cHandler = new ServletContextHandler();
cHandler.addServlet(new ServletHolder(new RestletHttpServlet(myRestlet)), "/myRestlet/*");
ContextHandlerCollection contextHandlers = new ContextHandlerCollection();
contextHandlers.setHandlers(new Handler[]{cHandler});
server.setHandler(contextHandlers);