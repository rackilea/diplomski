DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
Document doc = dbf.newDocumentBuilder().parse(isIn);
DOMHelper.useIdAsXmlId(doc.getDocumentElement());

KeyStore ks = KeyStore.getInstance("Windows-ROOT", "SunMSCAPI");
ks.load(null, null);
CertificateValidationProvider validationProviderMySigs = new PKIXCertificateValidationProvider(ks, false, null);
XadesVerificationProfile instance = new XadesVerificationProfile(validationProviderMySigs);
XadesVerifier verifier = instance.newVerifier();
XAdESVerificationResult r = verifier.verify(getSigElement(doc), null);