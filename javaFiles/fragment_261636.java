private X509Certificate generateCertificate(String dn, KeyPair keyPair, int validity, String sigAlgName) throws GeneralSecurityException, IOException {
    PrivateKey privateKey = keyPair.getPrivate();

    X509CertInfo info = new X509CertInfo();

    Date from = new Date();
    Date to = new Date(from.getTime() + validity * 1000L * 24L * 60L * 60L);

    CertificateValidity interval = new CertificateValidity(from, to);
    BigInteger serialNumber = new BigInteger(64, new SecureRandom());
    X500Name owner = new X500Name(dn);
    AlgorithmId sigAlgId = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);

    info.set(X509CertInfo.VALIDITY, interval);
    info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(serialNumber));
    info.set(X509CertInfo.SUBJECT, owner);
    info.set(X509CertInfo.ISSUER, owner);
    info.set(X509CertInfo.KEY, new CertificateX509Key(keyPair.getPublic()));
    info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
    info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(sigAlgId));

    // Sign the cert to identify the algorithm that's used.
    X509CertImpl certificate = new X509CertImpl(info);
    certificate.sign(privateKey, sigAlgName);

    // Update the algorith, and resign.
    sigAlgId = (AlgorithmId) certificate.get(X509CertImpl.SIG_ALG);
    info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, sigAlgId);
    certificate = new X509CertImpl(info);
    certificate.sign(privateKey, sigAlgName);

    return certificate;
}