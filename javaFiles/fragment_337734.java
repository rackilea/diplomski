PdfReader reader = new PdfReader(OUTPUT_FILE);
PdfDocument pdfDocument = new PdfDocument(reader);
PdfStream thumbnailStream = pdfDocument.getFirstPage().getPdfObject().getAsStream(PdfName.Thumb);
if (thumbnailStream != null) {
    PdfImageXObject thumbnail = new PdfImageXObject(thumbnailStream);
    BufferedImage image = thumbnail.getBufferedImage();
    //Output to file, memory, etc
}