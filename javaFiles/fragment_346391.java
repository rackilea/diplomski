package ahcs;

// many imports, press ctrl-o in eclipse

public class App {
    static final String url = "http://127.0.0.1:64738/test/";
    static final String content = "test\nfile\ndata";
    static final String httpUser = "testuser";
    static final String httpPasswd = "testPassword";
    static final String fileUploadFieldName = "uploadData";
    static final String fileName = "upload.dat";

    public static void main(String[] args) {
        System.err.println("Uploading to URL " + url);
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);

        MultipartEntityBuilder mpEntityBuilder =
            MultipartEntityBuilder.create();
        mpEntityBuilder.setMode(HttpMultipartMode.RFC6532);
        mpEntityBuilder.addBinaryBody(fileUploadFieldName,
            content.getBytes(), ContentType.DEFAULT_BINARY, fileName);

        httpPost.setEntity(mpEntityBuilder.build());
        System.err.println("executing request " + httpPost.getRequestLine());

        HttpEntity resEntity = null;

        try {
            // Really simple HTTP Authentification, grat Apache
            HttpHost httpHost = URIUtils.extractHost(new URI(url));
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(httpUser, httpPasswd));
            AuthCache authCache = new BasicAuthCache();
            authCache.put(httpHost, new BasicScheme());
            HttpClientContext context = HttpClientContext.create();
            context.setCredentialsProvider(credsProvider);
            context.setAuthCache(authCache);
            // context was missed
            HttpResponse response = httpclient.execute(httpPost, context);  
            resEntity = response.getEntity();

            System.err.println(response.getStatusLine().toString());
            if (resEntity != null) {
                System.err.println(EntityUtils.toString(resEntity));
            }
            int status = response.getStatusLine().getStatusCode();
            if (status != HttpStatus.SC_OK) {
                throw new HttpResponseException(status,
                    "Upload error! (" + status + ")");
            }
            EntityUtils.consume(resEntity);
            httpclient.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}