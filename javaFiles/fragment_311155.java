try {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    X509Certificate cert = (X509Certificate) cf.generateCertificate(in);
} catch (CertificateException e) {
    // handle failure to decode certificate
}