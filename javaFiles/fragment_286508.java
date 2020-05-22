ContentSigner getCertSigner(PrivateKey issuerKey) {
  AsymmetricKeyParameter akp = PrivateKeyFactory.createKey(issuerKey.getEncoded());
  AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find("SHA1withRSA");
  AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlgId);
  return new BcRSAContentSignerBuilder(sigAlgId, digAlgId).build(akp);
}

X509CertificateHolder generateCertificate(X509Certificate issuerCert, PrivateKey issuerKey, X500Name subject, PublicKey subjectKey, Date notBefore, Date notAfter) {
  X509Principal issuerDN = PrincipalUtil.getSubjectX509Principal(issuerCert);
  SubjectPublicKeyInfo key = SubjectPublicKeyInfo.getInstance(subjectKey.getEncoded());
  X509v3CertificateBuilder builder = new X509v3CertificateBuilder(issuerDN, BigInteger.valueOf(new SecureRandom().nextInt()), before, after, subject, key);

  // Add authority key identifier
  builder.addExtension(X509Extension.authorityKeyIdentifier, false, JcaX509ExtensionUtils.createAuthorityKeyIdentifier(issuerCert));

  // Add subject key identifier
  builder.addExtension(X509Extension.subjectKeyIdentifier, false, JcaX509ExtensionUtils.createSubjectKeyIdentifier(subjectKey));

  // Add basic constraints
  builder.addExtension(X509Extension.basicConstraints, true, new BasicConstraints(false));

  // Add key usage
  KeyUsage keyUsage = new KeyUsage(KeyUsage.keyEncipherment|KeyUsage.digitalSignature);
  builder.addExtension(X509Extension.keyUsage, true, keyUsage);

  // Add extended key usage
  ExtendedKeyUsage extKeyUsage = new ExtendedKeyUsage(KeyPurposeId.id_kp_serverAuth);
  builder.addExtension(X509Extension.extendedKeyUsage, false, extKeyUsage);

  return builder.build(getCertSigner(issuerKey));
}