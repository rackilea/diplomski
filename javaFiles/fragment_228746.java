public X509Certificate makeV3Certificate(
                                          X509Certificate caCertificate,
                                          PrivateKey caPrivateKey,
                                          PublicKey publicKey) 
throws GeneralSecurityException, CertIOException, OperatorCreationException {
    X509v3CertificateBuilder v3CertBuilder = new JcaX509v3CertificateBuilder(
            caCertificate.getSubjectX500Principal(), // issuer
            BigInteger.valueOf(System.currentTimeMillis()) // serial number
                    .multiply(BigInteger.valueOf(10)),
            new Date(System.currentTimeMillis() - 1000 * 5), // start time
            new Date(System.currentTimeMillis() + 1000 * 3600 * 3), // expiry time
            new X500Principal(String.format("CN=%s", "desirable Common Name")), // subject
            publicKey); // subject public key

    JcaX509ExtensionUtils extUtils = new JcaX509ExtensionUtils();

        v3CertBuilder.addExtension(
                Extension.subjectKeyIdentifier,
                false,
                extUtils.createSubjectKeyIdentifier(publicKey));
        v3CertBuilder.addExtension(
                Extension.authorityKeyIdentifier,
                false,
                extUtils.createAuthorityKeyIdentifier(caCertificate));
        v3CertBuilder.addExtension(
                Extension.basicConstraints,
                true,
                new BasicConstraints(false));
        JcaContentSignerBuilder signerBuilder = new JcaContentSignerBuilder("SHA256withRSA");

        return new JcaX509CertificateConverter().getCertificate(v3CertBuilder.build(signerBuilder.build(caPrivateKey)));
        }