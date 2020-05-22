byte[] rawCert = sig.toByteArray();
 InputStream certStream = new ByteArrayInputStream(rawCert);

 CertificateFactory certFactory;
 X509Certificate x509Cert;
 try {
      certFactory = CertificateFactory.getInstance("X509");
      x509Cert = (X509Certificate) certFactory.generateCertificate(certStream);

      //do stuff with your certificate
 } catch(Exception ex) {
      //handle exception
 }