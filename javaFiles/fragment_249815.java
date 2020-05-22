public class MyHttpClient implements HttpClient {
    private HttpClient httpClient;
    private String signinToken = ""

    public MyHttpClient() {
        this.httpClient = HttpClient5Factory.createHttpClient();
        this.signinToken = SigninTokenProvider.getToken();
    }

    @Override
    public HttpParams getParams() {
        return this.httpClient.getParams();
    }

    @Override
    public ClientConnectionManager getConnectionManager() {
        return this.httpClient.getConnectionManager();
    }

    ...
}