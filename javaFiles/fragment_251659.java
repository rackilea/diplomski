KeyStore ks = KeyStore.getInstance("BKS");
InputStream is = new FileInputStream("/etc/security/cacerts.bks");
ks.load(is, "changeit".toCharArray());

List<X509Certificate> certs = new ArrayList<X509Certificate>();
Enumeration<String> aliases = ks.aliases();
while (aliases.hasMoreElements()) {
  String alias = aliases.nextElement();
  X509Certificate cert = (X509Certificate) ks.getCertificate(alias);
  certs.add(cert);
}