public void resize (float x, float y, float scale) throws Exception {
    PdfReader reader = new PdfReader(pdfIn);
    Document doc = new Document(PageSize.LEGAL, 0, 0, 0, 0);
    PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(pdfOut));
    doc.open();
    PdfContentByte cb = writer.getDirectContent();
    for(int i=1; i<=reader.getNumberOfPages(); i++){
        doc.newPage();
        PdfImportedPage page = writer.getImportedPage(reader, i);
        cb.addTemplate(page, scale, 0, 0, scale, x, y);
    }
    doc.close();
}