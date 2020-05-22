public PKIXCertPathBuilderResult verifyCertificateChain(
     X509Certificate cert, 
     Set<X509Certificate> trustedRootCerts,
     Set<X509Certificate> intermediateCerts) throws GeneralSecurityException {

    // Create the selector that specifies the starting certificate
    X509CertSelector selector = new X509CertSelector(); 
    selector.setCertificate(cert);

    // Create the trust anchors (set of root CA certificates)
    Set<TrustAnchor> trustAnchors = new HashSet<TrustAnchor>();
    for (X509Certificate trustedRootCert : trustedRootCerts) {
        trustAnchors.add(new TrustAnchor(trustedRootCert, null));
    }

    // Configure the PKIX certificate builder algorithm parameters
    PKIXBuilderParameters pkixParams = 
        new PKIXBuilderParameters(trustAnchors, selector);

    // Disable CRL checks (this is done manually as additional step)
    pkixParams.setRevocationEnabled(false);

    // Specify a list of intermediate certificates
    // certificate itself has to be added to the list 
    intermediateCerts.add(cert); 
    CertStore intermediateCertStore = CertStore.getInstance("Collection",
        new CollectionCertStoreParameters(intermediateCerts), "BC");
    pkixParams.addCertStore(intermediateCertStore);

    // Build and verify the certification chain
    CertPathBuilder builder = CertPathBuilder.getInstance("PKIX", "BC");
    PKIXCertPathBuilderResult result = 
        (PKIXCertPathBuilderResult) builder.build(pkixParams);
    return result;
}