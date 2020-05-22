PdfReader reader = new PdfReader(resource);
AcroFields acroFields = reader.getAcroFields();

List<String> names = acroFields.getSignatureNames();
for (String name : names) {
   System.out.println("Signature name: " + name);
   System.out.println("Signature covers whole document: " + acroFields.signatureCoversWholeDocument(name));
   System.out.println("Document revision: " + acroFields.getRevision(name) + " of " + acroFields.getTotalRevisions());
   PdfPKCS7 pk = acroFields.verifySignature(name);
   System.out.println("Subject: " + CertificateInfo.getSubjectFields(pk.getSigningCertificate()));
   System.out.println("Document verifies: " + pk.verify());
}