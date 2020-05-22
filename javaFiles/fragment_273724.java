CertPathBuilder cpb = CertPathBuilder.getInstance("PKIX");
X509CertSelector certSelector = new X509CertSelector();
certSelector.setCertificate((X509Certificate) myKeyStore.getCertificate("mykey"));
PKIXBuilderParameters cpp = new PKIXBuilderParameters(trustAnchors, certSelector);
cpp.addCertStore(cs);
cpp.setRevocationEnabled(true);
cpp.setMaxPathLength(6);
cpp.setDate(new Date());

CertPathBuilderResult a = cpb.build(cpp);
CertPath certPath = a.getCertPath();