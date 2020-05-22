@Autowired
HttpClient httpClient;

public HttpResponse execute(String url, String json, String accessToken) {
    HttpOptionsWithBody httpOptionsWithBody = new HttpOptionsWithBody(url);
    httpOptionsWithBody.setEntity(new StringEntity(json));
    return httpClient.execute(httpOptionsWithBody);
}

private static class HttpOptionsWithBody extends HttpEntityEnclosingRequestBase {

    public static final String METHOD_NAME = "OPTIONS";

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpOptionsWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }
}