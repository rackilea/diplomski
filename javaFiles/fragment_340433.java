public void manipulatePdf(String src, String stationery, String dest)
    throws IOException, DocumentException {
    // Create readers
    PdfReader reader = new PdfReader(src);
    PdfReader s_reader = new PdfReader(stationery);
    // Create the stamper
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    // Add the stationery to each page
    PdfImportedPage page = stamper.getImportedPage(s_reader, 1);
    int n = reader.getNumberOfPages();
    PdfContentByte background;
    for (int i = 1; i <= n; i++) {
        background = stamper.getUnderContent(i);
        background.addTemplate(page, 0, 0);
    }
    // CLose the stamper
    stamper.close();
    reader.close();
    s_reader.close();
}