PdfDocument pdfDocument = new PdfDocument(
    new PdfReader(INPUT),
    new PdfWriter(OUTPUT),
    new StampingProperties().useAppendMode());

try (pdfDocument) {
    List<PdfOutline> outlines = pdfDocument.getOutlines(false).getAllChildren();
    for (PdfOutline outline : outlines) {
        outline.setTitle("Title");
        outline.getContent().setModified();
    }
}