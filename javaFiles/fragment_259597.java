CloseableHttpClient httpclient = HttpClients.custom().addInterceptorLast(new HttpResponseInterceptor() {

    @Override
    public void process(
            HttpResponse response, HttpContext context) throws HttpException, IOException {
        HttpCoreContext coreContext = HttpCoreContext.adapt(context);
        ManagedHttpClientConnection conn = coreContext.getConnection(ManagedHttpClientConnection.class);
        SSLSession sslSession = conn.getSSLSession();
        if (sslSession != null) {
            X509Certificate[] certs = sslSession.getPeerCertificateChain();
            if (certs.length == 1) {
                String sha1Hex = null;
                try {
                    sha1Hex = DigestUtils.sha1Hex(certs[0].getEncoded());
                } catch (CertificateEncodingException ex) {
                    throw new HttpException("Messged up cert", ex);
                }
                boolean check = sha1Hex.equals("xxxxxxxx");
            }
        }
    }

}).setSSLSocketFactory(sslsf).build();