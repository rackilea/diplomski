@Inject
private EmbeddedWebApplicationContext appContext;

public String getBaseUrl() throws UnknownHostException {
    Connector connector = ((TomcatEmbeddedServletContainer) appContext.getEmbeddedServletContainer()).getTomcat().getConnector();
    String scheme = connector.getScheme();
    String ip = InetAddress.getLocalHost().getHostAddress();
    int port = connector.getPort();
    String contextPath = appContext.getServletContext().getContextPath();
    return scheme + "://" + ip + ":" + port + contextPath;
}