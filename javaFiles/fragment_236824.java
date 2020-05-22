private static final int PORT = 8080;
private static final String WAR_LOCATION = "src/webapps"; //in your case I guess
private static final String CONTEXT_PATH = "/movence"; //change it if you want

public static void main(String[] args) throws Exception {
    Server server = new Server();
    WebAppContext context = new WebAppContext();
    SocketConnector connector = new SocketConnector();

    setupConnector(connector);
    setupContext(server, context);
    setupServer(server, context, connector);
    startServer(server);
}

private static void startServer(Server server) throws Exception, InterruptedException {
    server.start();
    server.join();
}

private static void setupServer(Server server, WebAppContext context, SocketConnector connector) {
    server.setConnectors(new Connector[] { connector });
    server.addHandler(context);
}

private static void setupConnector(SocketConnector connector) {
    connector.setPort(PORT);
}

private static void setupContext(Server server, WebAppContext context) {
    context.setServer(server);
    context.setContextPath(CONTEXT_PATH);
    context.setWar(WAR_LOCATION);
}