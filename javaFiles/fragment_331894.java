public static void main(String[] args) throws Exception {
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
        addWatermark(pdfDocument, "iText Watermark");
        pdfDocument.close();

        pdfDocument = new PdfDocument(new PdfReader(DEST), new PdfWriter(DEST2));
        removeWatermarkFromPDF(pdfDocument);
        pdfDocument.close();
}