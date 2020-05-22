((AbstractHttpClient)client).addResponseInterceptor(new HttpResponseInterceptor() {
    @Override
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {
        HttpRoutedConnection routedConnection= (HttpRoutedConnection)context.getAttribute(ExecutionContext.HTTP_CONNECTION);
        if( routedConnection.isSecure() ) {
            Certificate[] certificates= routedConnection.getSSLSession().getPeerCertificates();
            // Assume that PEER_CERTIFICATES is a constant you've defined
            context.setAttribute(PEER_CERTIFICATES, certificates);
        }
    }
});