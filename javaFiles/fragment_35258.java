public static void main(String[] args) throws Exception
{
    Server server = new Server(8080);

    // Figure out what path to serve content from
    ClassLoader cl = MyEmbeddedJettyMain.class.getClassLoader();
    // We look for a file, as ClassLoader.getResource() is not
    // designed to look for directories (we resolve the directory later)
    URL f = cl.getResource("static-root/hello.html");
    if (f == null)
    {
        throw new RuntimeException("Unable to find resource directory");
    }

    // Resolve file to directory
    URI webRootUri = f.toURI().resolve("./").normalize();
    System.err.println("WebRoot is " + webRootUri);

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    context.setBaseResource(Resource.newResource(webRootUri));
    context.setWelcomeFiles(new String[]{"welcome.html"});

    ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
    holderPwd.setInitParameter("dirAllowed","true");
    context.addServlet(holderPwd,"/");

    server.setHandler(context);

    server.start();
    server.join();
}