//Export a certificate list to PKCS#7
public static byte[] exportCertificatesAsPkcs7(X509Certificate certs[]) throws Exception {

    List certList = new ArrayList();
    for (X509Certificate certificate: certs){
        certList.add(new X509CertificateHolder(certificate.getEncoded()));
    }
    Store certStore = new JcaCertStore(certList);

    CMSProcessableByteArray msg = new CMSProcessableByteArray("Hello World".getBytes());
    CMSSignedDataGenerator    gen = new CMSSignedDataGenerator(); 
    gen.addCertificates(certStore);
    CMSSignedData data = gen.generate(msg, "BC"); 
    return data.getEncoded();

}