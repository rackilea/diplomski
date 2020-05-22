SpnegoClient spnegoClient = SpnegoClient.loginWithKeyTab("svc_consumer", "/opt/myapp/consumer.keytab");

@Override
public void beforeRequest(Map<String,List<String>> headers) {
    SpnegoContext context = spnegoClient.createContext("https://ws.server.com");
    headers.put("Authorization", Collections.singletonList(context.createTokenAsAuthroizationHeader()));
}