public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    Phrase header = new Phrase("Copy", new Font(FontFamily.HELVETICA, 14));
    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
        float x = reader.getPageSize(i).getWidth() / 2;
        float y = reader.getPageSize(i).getTop(20);
        ColumnText.showTextAligned(
            stamper.getOverContent(i), Element.ALIGN_CENTER,
            header, x, y, 0);
    }
    stamper.close();
    reader.close();
}