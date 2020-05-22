public PublicKey loadPKCS#12(String filePath, char[] password) throws Exception {
  InputStream is = null;
  KeyStore ks = KeyStore.getInstance("PKCS12");
  try {
    is = new FileInputStream(filePath);
    ks.load(is, password);
    for (Enumeration<String> e = ks.aliases(); e.hasMoreElements();) {
      String alias = e.nextElement();
      if (ks.isCertificateEntry(alias)) {
        Certificate cert = ks.getCertificate(alias);
        return cert.getPublicKey();
      }
    }
    return null;
  } finally {
    if (is != null) {
      is.close();
    }
  }
}