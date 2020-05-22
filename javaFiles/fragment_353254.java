@Component
public class RestClient {

    @ComponentImport
    private TrustedTokenFactory tokenFactory;

    // [...]
    public String doRequest(HttpClient client, String url) throws Exception {
        TrustedTokenAuthenticator auth = 
           new TrustedTokenAuthenticator(tokenFactory);
        HttpMethod method = auth.makeMethod(client, url);
        try {
             // add request headers, etc... 
             int statusCode = client.executeMethod(method);   
             // be sure to use response data here, catch exceptions...   
        } finally {
             method.releaseConnection();
        }
    }
}