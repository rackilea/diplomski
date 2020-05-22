HttpClient client = new HttpClient();
HttpMethod method = new GetMethod("http://www.kodejava.org");
HostConfiguration config = client.getHostConfiguration();

config.setProxy(PROXY_HOST, PROXY_PORT);
String username = "guest"; String password = "s3cr3t";
Credentials credentials = new UsernamePasswordCredentials(username, password);
AuthScope authScope = new AuthScope(PROXY_HOST, PROXY_PORT);
client.getState().setProxyCredentials(authScope, credentials);