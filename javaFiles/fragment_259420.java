try (   PdfReader pdfReader = new PdfReader(SOURCE);
        PdfWriter pdfWriter = new PdfWriter(TARGET);
        PdfDocument pdfDocument = new PdfDocument(pdfReader, pdfWriter,
                new StampingProperties().preserveEncryption().useAppendMode())) {
    AdobeLtvEnabling adobeLtvEnabling = new AdobeLtvEnabling(pdfDocument);
    IOcspClient ocsp = new OcspClientBouncyCastle(null);
    ICrlClient crl = new CrlClientOnline();
    adobeLtvEnabling.enable(ocsp, crl);
}