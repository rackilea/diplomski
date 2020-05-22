private ClientEndpointConfig createClientConfig() throws KeyManagementException, UnrecoverableKeyException,
 NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
    ClientEndpointConfig.Builder builder = ClientEndpointConfig.Builder.create();
    ClientEndpointConfig config = builder.decoders(new ArrayList<>()).encoders(new ArrayList<>())
            .preferredSubprotocols(new ArrayList<>()).build();
    SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(clientCert.toFile(), clientCertPassword,
            clientCertPassword, (aliases, socket) -> aliases.keySet().iterator().next()).build();
    config.getUserProperties().put(Constants.SSL_CONTEXT_PROPERTY, sslContext);
    return config;
}