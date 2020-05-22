public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    Font f = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, true);
    Paragraph p1 = new Paragraph("\u0915\u093e\u0930 "
            + "\u092a\u093e\u0930\u094d\u0915\u093f\u0902\u0917", f);
    document.add(p1);
    Paragraph p2 = new Paragraph("\\u0915 \u0915 \\u093e \u093e \\0930 \u0930\n"
            + "\\u092a \u092a \\u093e \u093e \\u0930 \u0930 \\u094d \u094d"
            + "\\u0915 \u0915 \\u093f \\u093f \u093f \\u0902 \u0902"
            + "\\u0917 \u0917", f);
    document.add(p2);
    document.close();
}