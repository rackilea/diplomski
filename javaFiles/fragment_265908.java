public String getBaseUrl() throws UnknownHostException {
    ServerConnector connector = (ServerConnector) ((JettyEmbeddedServletContainer) appContext.getEmbeddedServletContainer()).getServer().getConnectors()[0];
    String scheme = connector.getDefaultProtocol().toLowerCase().contains("ssl") ? "https" : "http";
    String ip = InetAddress.getLocalHost().getHostAddress();
    int port = connector.getLocalPort();

    String contextPath = appContext.getServletContext().getContextPath();
    return scheme + "://" + ip + ":" + port + contextPath;
}