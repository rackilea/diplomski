KeyStore trustAnchors = getTrustAnchors();
X509CertSelector target = new X509CertSelector();
target.setCertificate(signerCertificate);
PKIXBuilderParameters params = new PKIXBuilderParameters(anchors, target);
CertStoreParameters additionalCerts = new CollectionCertStoreParameters(allOtherCerts)
params.addCertStore(CertStore.getInstance("Collection", additionalCerts));
CertStoreParameters revocationObjects = new CollectionCertStoreParameters(allCRLs);
params.addCertStore(CertStore.getInstance("Collection", revocationObjects));
CertPathBuilder builder = CertPathBuilder.getInstance("PKIX");
PKIXCertPathBuilderResult r = (PKIXCertPathBuilderResult) builder.build(params);
/* if the build method returns without exception, the certificate chain is valid */