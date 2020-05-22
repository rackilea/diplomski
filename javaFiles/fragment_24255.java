public X509Certificate generateCertificate(KeyPair keyPair){  
   X509V3CertificateGenerator cert = new X509V3CertificateGenerator();   
   cert.setSerialNumber(BigInteger.valueOf(1));   //or generate a random number  
   cert.setSubjectDN(new X509Principal("CN=localhost"));  //see examples to add O,OU etc  
   cert.setIssuerDN(new X509Principal("CN=localhost")); //same since it is self-signed  
   cert.setPublicKey(keyPair.getPublic());  
   cert.setNotBefore(<date>);  
   cert.setNotAfter(<date>);  
   cert.setSignatureAlgorithm("SHA1WithRSAEncryption");   
    PrivateKey signingKey = keyPair.getPrivate();    
   return cert.generate(signingKey, "BC");  
}