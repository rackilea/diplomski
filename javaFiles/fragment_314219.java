final KeyStore truststore = readStore();

final SSLContext sslContext;
try {
  sslContext = SSLContexts.custom()
      .loadTrustMaterial(truststore, new TrustAllStrategy())
      .loadKeyMaterial(truststore, keyStorePass.toCharArray(), (aliases, socket) -> "qlikClient")
      .build();
} catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | UnrecoverableKeyException e) {
  throw new RuntimeException("Failed to read keystore", e);
}
final CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();