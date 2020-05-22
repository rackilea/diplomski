private KeyStore readStore() {
  try (InputStream keyStoreStream = new FileInputStream(KEYSTORE_PATH)) {
    KeyStore keyStore = KeyStore.getInstance("PKCS12"); // or "JKS"
    keyStore.load(keyStoreStream, keyStorePass.toCharArray());
    return keyStore;
  } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException e) {
    throw new RuntimeException(e);
  }
}