public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfDictionary root = reader.getCatalog();
    PdfDictionary names = root.getAsDict(PdfName.NAMES);
    PdfDictionary embeddedFiles = names.getAsDict(PdfName.EMBEDDEDFILES);
    PdfArray namesArray = embeddedFiles.getAsArray(PdfName.NAMES);
    namesArray.remove(0);
    namesArray.remove(0);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.close();
}