public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfDictionary root = reader.getCatalog();
    PdfDictionary names = root.getAsDict(PdfName.NAMES);
    names.remove(PdfName.EMBEDDEDFILES);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.close();
}