public class HttpFactoryBean implements FactoryBean<HttpClient>{

private String host;
private int port;


public HttpClient getObject() throws Exception {
    return new StdHttpClient.Builder()
                            .host(host)
                            .port(port)
                            .build();
}

public Class<? extends HttpClient> getObjectType() {
    return StdHttpClient.class;
}

public boolean isSingleton() {
    return true;
}

public void setHost(String host) {
    this.host = host;
}

public void setPort(int port) {
    this.port = port;
}}