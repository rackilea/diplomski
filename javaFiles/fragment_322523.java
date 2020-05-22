public static X509TrustManager load(List<File> serverCerts)
      throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException {
    return trustManagerForKeyStore(keyStoreForCerts(serverCerts));
  }

  public static X509TrustManager trustManagerForKeyStore(KeyStore ks)
      throws NoSuchAlgorithmException, KeyStoreException {
    TrustManagerFactory tmf =
        TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

    tmf.init(ks);

    return (X509TrustManager) tmf.getTrustManagers()[0];
  }

  public static KeyStore keyStoreForCerts(List<File> serverCerts)
      throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null);

    for (int i = 0; i < serverCerts.size(); i++) {
      try (InputStream is = new FileInputStream(serverCerts.get(i))) {
        X509Certificate caCert = (X509Certificate) cf.generateCertificate(is);
        ks.setCertificateEntry("cacrt." + i, caCert);
      }
    }
    return ks;
  }