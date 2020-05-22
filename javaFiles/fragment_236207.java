public void onEndPage(PdfWriter writer, Document document) {
    PdfContentByte cb = writer.getDirectContent();
    cb.saveState();
    cb.setColorStroke(new CMYKColor(1f, 0f, 0f, 0f));
    cb.setColorFill(new CMYKColor(1f, 0f, 0f, 0f));
    cb.rectangle(20,10,10,820);
    cb.fill();
    cb.restoreState();
}