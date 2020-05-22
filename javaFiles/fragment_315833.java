Server server = new Server(8080);

String rootPath = SimplestServer.class.getClassLoader().getResource(".").toString();
WebAppContext webapp = new WebAppContext(rootPath + "../../src/main/webapp", "");
server.setHandler(webapp);

server.start();
server.join();