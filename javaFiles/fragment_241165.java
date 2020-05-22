KeyFactory kf = KeyFactory.getInstance ("DSTU4145", "BC");
PrivateKey key = kf.generatePrivate (new PKCS8EncodedKeySpec (Files.readAllBytes("key")));
CertificateFactory cf = CertificateFactory.getInstance ("X.509", "BC");
// not sure we need the BC implementation for the certs, but can't hurt 
Certificate[] certs = new Certificate[4];
for( int i = 0; i < 4; i++ ){
  certs[i] = cf.generateCertificate (new FileInputStream ("cert"+i));
  // or "cert"+i+".pem" -- CertificateFactory can read either DER or PEM
}
// or concatenate the cert PEM files into one and do
Certificate[] certs = cf.generateCertificates (new FileInputStream ("certs.pem")).toArray(new Certificate[0]);
// better to close the stream(s) when done like below but for input isn't vital

KeyStore ks = KeyStore.getInstance ("PKCS12", "BC"); ks.load(null); 
char[] pw = "password".toCharArray(); // or preferably better value
ks.setKeyEntry("mykey", pkey, pw, certs);
try(OutputStream os = new FileOutputStream("result")){ ks.store(os, pw); }