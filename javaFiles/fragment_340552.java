Document document = new Document(new Rectangle(500, 500));
PdfWriter writer = PdfWriter.getInstance(document, baos);
document.open();
PdfContentByte canvas = writer.getDirectContent();
for (int i = 0; i < 5; i++) {
    canvas.addImage(image, 50, 0, 0, 50, i * 100 + 25, i * 100 + 25, true);
}
document.close();