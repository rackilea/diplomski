// Extract the ServletContext from the attributes of RestletContext
    ServletContext servlet = (ServletContext) context.getAttributes().get("org.restlet.ext.servlet.ServletContext");
// Get the path of the config file relative to the WAR
    String rootPath = servlet.getRealPath("/WEB-INF/configuration.txt");
    Path path = Paths.get(rootPath);
    File configFile = new File(path.toString());
    FileRepresentation file = new FileRepresentation(configFile, MediaType.TEXT_PLAIN);