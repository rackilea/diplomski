PdfWriter writer = PdfWriter.getInstance(document, outputStream);
writer.setPageEvent(new FooterGenerator());

document.open();
document.setMargins(MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM);
document.add(generateHeader());
document.add(generateContent());
appendTermsAndConditions(writer, document, context.getRealPath("/files/terms-and-conditions.pdf");
document.close();

protected void appendTermsAndConditions(PdfWriter writer, Document document, String fileName) throws IOException {
   File f = new File(fileName);
   if (f.exists()) {
    PdfReader reader = new PdfReader(fileName);
    PdfContentByte cb = writer.getDirectContent();
    int pagesCount = reader.getNumberOfPages();
    PdfImportedPage page;
    for (int i = 0; i < pagesCount; i++) {
        document.newPage();
        page = writer.getImportedPage(reader, document.getPageNumber() + 1);
        cb.addTemplate(page, 0, 0);
    }
   }
}