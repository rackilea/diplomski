@Bean
public SSLContext sslContext() throws KeyManagementException, NoSuchAlgorithmException {
    SSLContext ctx = SSLContext.getInstance("TLS"); // or try "SSL"
    ctx.init(null, new TrustManager[] { new NonValidatingTrustManager() }, null);
    return ctx;
}