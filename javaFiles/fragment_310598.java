CertificateFactory cf = CertificateFactory.getInstance("X.509");

// Get ContentInfo
//byte[] signature = ... // PKCS#7 signature bytes
InputStream signatureIn = new ByteArrayInputStream(signature);
DERObject obj = new ASN1InputStream(signatureIn).readObject();
ContentInfo contentInfo = ContentInfo.getInstance(obj);

// Extract certificates
SignedData signedData = SignedData.getInstance(contentInfo.getContent());
Enumeration certificates = signedData.getCertificates().getObjects();

// Build certificate path
List certList = new ArrayList();
while (certificates.hasMoreElements()) {
    DERObject certObj = (DERObject) certificates.nextElement();
    InputStream in = new ByteArrayInputStream(certObj.getDEREncoded());
    certList.add(cf.generateCertificate(in));
}
CertPath certPath = cf.generateCertPath(certList);

// Load key store
//String keyStorePath = ...
KeyStore keyStore = KeyStore.getInstance("JKS");
keyStore.load(new FileInputStream(keyStorePath), null);

// Set validation parameters
PKIXParameters params = new PKIXParameters(keyStore);
params.setRevocationEnabled(false); // to avoid exception on empty CRL

// Validate certificate path
CertPathValidator validator = CertPathValidator.getInstance("PKIX");
CertPathValidatorResult result = validator.validate(certPath, params);