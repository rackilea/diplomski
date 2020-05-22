public static void main(String[] args) throws Exception {
    Engine.setLogLevel(java.util.logging.Level.INFO);
    Component component = new Component();
    component.getLogService().setLoggerName("net.asdf.WebComponent.www");
    component.getDefaultHost().attach(new TestPatrick());

    // Attach the server connectors descriptors to the component
    component.getServers().add(startHttpsServer(component, 443));
    component.getServers().add(startHttpServer(component, 8182));
    // Start the component, which will lead to start, at the end, the real connectors.
    component.start();
}

private static Server startHttpServer(Component component, Integer port) throws Exception {
    return new Server(Protocol.HTTP, port, component);
}

private static Server startHttpsServer(Component component, Integer port) throws Exception {
    // create embedding https jetty server
    Server server = new Server(new Context(), Protocol.HTTPS, port, component);

    Series<Parameter> parameters = server.getContext().getParameters();
    parameters.add("keystore", "jks/keystore.jks");
    parameters.add("keyStorePath", "jks/keystore.jks");
    parameters.add("keyStorePassword", "xxx");
    parameters.add("keyManagerPassword", "xxx");
    parameters.add("keyPassword", "xxx");
    parameters.add("password", "xxx");
    parameters.add("keyStoreType", KeyStore.getDefaultType());
    parameters.add("tracing", "true");
    parameters.add("truststore", "jks/keystore.jks");
    parameters.add("trustStorePath", "jks/keystore.jks");
    parameters.add("trustStorePassword", "xxx");
    parameters.add("trustPassword", "xxx");
    parameters.add("trustStoreType", KeyStore.getDefaultType());
    parameters.add("allowRenegotiate", "true");
    parameters.add("type", "1");

    return server;
}