@Component
public class ServiceConnector {
    private final HttpClient client;


    public ServiceConnector() {
        client = HttpClientBuilder.create().build();
    }
    public String post(String url, String acceptHeader, Optional<String> bearerToken) throws UnauthorizedException {

    try {
        HttpPost request = new HttpPost(url);
        request.addHeader("Accept", acceptHeader);
        if (bearerToken.isPresent()) {
            request.addHeader("Authorization", "Bearer " + bearerToken.get());
        }
        StringEntity params =new StringEntity("details {\"name\":\"myname\",\"age\":\"20\"} ");
    // You could open, read, and convert the file content into a json-string (use GSON lib here)
        request.addHeader("content-type", "application/json");
        request.addHeader("Accept","application/json");
        request.setEntity(params);
        HttpResponse response = client.execute(request);

        // handle response here...
    }catch (Exception ex) {
        // handle exception here
    } finally {
        client.getConnectionManager().shutdown();
    }
}