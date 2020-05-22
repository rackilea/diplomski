KeyStore kall = PdfPKCS7.loadCacertsKeyStore();
PdfReader reader = new PdfReader("my_signed_doc.pdf");
AcroFields af = reader.getAcroFields();
ArrayList names = af.getSignatureNames();
for (int k = 0; k < names.size(); ++k) {
    String name = (String)names.get(k);
    System.out.println("Signature name: " + name);
    System.out.println("Signature covers whole document: " + af.signatureCoversWholeDocument(name));
    PdfPKCS7 pk = af.verifySignature(name);
    Calendar cal = pk.getSignDate();
    Certificate pkc[] = pk.getCertificates();
    System.out.println("Subject: " + PdfPKCS7.getSubjectFields(pk.getSigningCertificate()));
    System.out.println("Document modified: " + !pk.verify());
    Object fails[] = PdfPKCS7.verifyCertificates(pkc, kall, null, cal);
    if (fails == null)
        System.out.println("Certificates verified against the KeyStore");
    else
        System.out.println("Certificate failed: " + fails[1]);
}