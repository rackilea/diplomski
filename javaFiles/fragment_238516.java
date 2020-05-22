@Configuration
public class AppConfig {

@Autowired
private ServletWebServerApplicationContext server;

private static FilterConfig filterConfig = new FilterConfig();

@PostConstruct
void init() {
    //setting default port config
    filterConfig.addNewPortConfig(8080, "/admin");
}

@Bean
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public FilterConfig createFilterConfig() {
    return filterConfig;
}

public void addPort(String schema, String domain, int port, boolean secure) {
    TomcatWebServer ts = (TomcatWebServer) server.getWebServer();
    synchronized (this) {
        ts.getTomcat().setConnector(createConnector(schema, domain, port, secure));
    }
}

public void addContextAllowed(FilterConfig filterConfig, int port, String context) {
    filterConfig.addNewPortConfig(port, context);
}

 public void removePort(int port) {
    TomcatWebServer ts = (TomcatWebServer) server.getWebServer();
    Service service = ts.getTomcat().getService();
    synchronized (this) {
        Connector[] findConnectors = service.findConnectors();
        for (Connector connector : findConnectors) {
            if (connector.getPort() == port) {
                try {
                    connector.stop();
                    connector.destroy();
                    filterConfig.removePortConfig(port);
                } catch (LifecycleException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

private Connector createConnector(String schema, String domain, int port, boolean secure) {
    Connector conn = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    conn.setScheme(schema);
    conn.setPort(port);
    conn.setSecure(true);
    conn.setDomain(domain);
    if (secure) {
        // config secure port...
    }
    return conn;
}
}