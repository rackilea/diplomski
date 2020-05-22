/**
 * HTTP request types
 */
public static final int POST_TYPE   = 1;
public static final int GET_TYPE    = 2;
public static final int PUT_TYPE    = 3;
public static final int DELETE_TYPE = 4;

/**
 * HTTP request header constants
 */
public static final String CONTENT_TYPE         = "Content-Type";
public static final String ACCEPT_ENCODING      = "Accept-Encoding";
public static final String CONTENT_ENCODING     = "Content-Encoding";
public static final String ENCODING_GZIP        = "gzip";
public static final String MIME_FORM_ENCODED    = "application/x-www-form-urlencoded";
public static final String MIME_TEXT_PLAIN      = "text/plain";

private InputStream performRequest(final String contentType, final String url, final String user, final String pass,
    final Map<String, String> headers, final Map<String, String> params, final int requestType) 
            throws IOException {

    DefaultHttpClient client = HTTPClientFactory.newClient();

    client.getParams().setParameter(HttpProtocolParams.USER_AGENT, mUserAgent);

    // add user and pass to client credentials if present
    if ((user != null) && (pass != null)) {
        client.getCredentialsProvider().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, pass));
    }

    // process headers using request interceptor
    final Map<String, String> sendHeaders = new HashMap<String, String>();
    if ((headers != null) && (headers.size() > 0)) {
        sendHeaders.putAll(headers);
    }
    if (requestType == HTTPRequestHelper.POST_TYPE || requestType == HTTPRequestHelper.PUT_TYPE ) {
        sendHeaders.put(HTTPRequestHelper.CONTENT_TYPE, contentType);
    }
    // request gzip encoding for response
    sendHeaders.put(HTTPRequestHelper.ACCEPT_ENCODING, HTTPRequestHelper.ENCODING_GZIP);

    if (sendHeaders.size() > 0) {
        client.addRequestInterceptor(new HttpRequestInterceptor() {

            public void process(final HttpRequest request, final HttpContext context) throws HttpException,
                IOException {
                for (String key : sendHeaders.keySet()) {
                    if (!request.containsHeader(key)) {
                        request.addHeader(key, sendHeaders.get(key));
                    }
                }
            }
        });
    }

    //.... code omitted ....//

}