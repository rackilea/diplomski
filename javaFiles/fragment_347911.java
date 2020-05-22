public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    BaseFont bf = BaseFont.createFont(
        FONT, BaseFont.IDENTITY_V, BaseFont.NOT_EMBEDDED);
    Font font = new Font(bf, 20);
    VerticalText vt = new VerticalText(writer.getDirectContent());
    vt.setVerticalLayout(559, 806, 770, 29, 18);
    vt.addText(new Phrase("Hello World !!!", font));
    vt.go();
    document.close();
}