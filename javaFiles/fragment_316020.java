DefaultHttpClient httpclient = new DefaultHttpClient();
httpclient.addRequestInterceptor(new HttpRequestInterceptor() {

    public void process(
            HttpRequest request, HttpContext context) throws HttpException, IOException {
        HttpRoutedConnection conn = (HttpRoutedConnection) context.getAttribute(
                ExecutionContext.HTTP_CONNECTION);
        SSLSession sslsession = conn.getSSLSession();
        if (sslsession != null) {
            // Do something useful with the SSL session details
            // and if necessary stick the result to the execution context
            // for further processing
            X509Certificate[] certs = sslsession.getPeerCertificateChain();
            for (X509Certificate cert: certs) {
                System.out.println(cert);
            }
        }
    }
});
HttpResponse response = httpclient.execute(new HttpGet("https://verisign.com/"));
EntityUtils.consume(response.getEntity());