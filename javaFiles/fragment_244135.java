PEMParser pemParser = new PEMParser(new BufferedReader(new InputStreamReader(certStream)));
Object pemCertObj = pemParser.readObject();
PemObject pemKeyObj = pemParser.readPemObject();

PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(pemKeyObj.getContent());
KeyFactory kf = KeyFactory.getInstance("RSA");
PrivateKey privKey = kf.generatePrivate(privKeySpec);

Security.addProvider(new BouncyCastleProvider());
X509CertificateHolder certHolder = (X509CertificateHolder)pemCertObj;
X509Certificate x509cert = (new JcaX509CertificateConverter()).setProvider("BC").getCertificate(certHolder);