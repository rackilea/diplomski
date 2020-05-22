CertificateFactory cf = CertificateFactory.getInstance("X.509");
List<Certificate> certx = new ArrayList<>(certChain.length);
for (byte[] c : certChain)
  certx.add(cf.generateCertificate(new ByteArrayInputStream(c)));
CertPath path = cf.generateCertPath(certx);
CertPathValidator validator = CertPathValidator.getInstance("PKIX");
KeyStore keystore = KeyStore.getInstance("JKS");
try (InputStream is = Files.newInputStream(Paths.get("cacerts.jks"))) {
  keystore.load(is, "changeit".toCharArray());
}
Collection<? extends CRL> crls;
try (InputStream is = Files.newInputStream(Paths.get("crls.p7c"))) {
  crls = cf.generateCRLs(is);
}
PKIXParameters params = new PKIXParameters(keystore);
CertStore store = CertStore.getInstance("Collection", new CollectionCertStoreParameters(crls));
/* If necessary, specify the certificate policy or other requirements 
 * with the appropriate params.setXXX() method. */
params.addCertStore(store);
/* Validate will throw an exception on invalid chains. */
PKIXCertPathValidatorResult r = (PKIXCertPathValidatorResult) validator.validate(path, params);