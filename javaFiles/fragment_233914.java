public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader.unethicalreading = true;
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    stamper.close();
    reader.close();
}