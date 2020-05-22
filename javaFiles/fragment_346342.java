@TestConfiguration
class TestConfig {

    @Bean
    public SSLContext sslContext() throws Exception {
        SSLContext ctx = SSLContext.getInstance("TLS"); // or try "SSL"
        ctx.init(null, new TrustManager[] { new NonValidatingTrustManager() }, null);
        return ctx;
    }
}