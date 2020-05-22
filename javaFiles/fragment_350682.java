KeyStore ks = KeyStore.getInstance("pkcs12");
ks.load(new FileInputStream(file), password.toCharArray());
Enumeration<String> enumeration = ks.aliases();
while (enumeration.hasMoreElements()) {
  String alias = enumeration.nextElement();
  Certificate certificate = ks.getCertificate(alias);
  RSAPublicKey pub = (RSAPublicKey) certificate.getPublicKey();
  System.out.println(pub.getModulus().toString(16));
  System.out.println(pub.getPublicExponent().toString(16));
}