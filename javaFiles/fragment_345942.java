ResourceHandler staticResource = new ResourceHandler();
staticResource.setDirectoriesListed(true);
staticResource.setWelcomeFiles(new String[] { "index.html" });
staticResource.setResourceBase("/path/to/your/files");

ContextHandler staticContextHandler = new ContextHandler();
staticContextHandler.setContextPath("/*");
staticContextHandler.setHandler(staticResource);

Server server = new Server(8080);
server.setHandler(staticContextHandler);