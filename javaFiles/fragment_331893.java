private static void removeWatermarkFromPDF(PdfDocument pdfDocument) throws IOException {
    PdfObject obj;
    for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++) {
        PdfArray contentObjects = pdfDocument.getPage(i).getPdfObject().getAsArray(PdfName.Contents);
        for (int j = 0; j <= contentObjects.size() - 1; j++) {
            obj = contentObjects.get(j);
            if (obj != null && obj.isStream()) {
                byte[] b;
                try {
                    b = ((PdfStream) obj).getBytes();
                } catch (PdfException exc) {
                    b = ((PdfStream) obj).getBytes(false);
                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                baos.write(b);
                if (baos.toString().contains("iText Watermark")) {
                    contentObjects.remove(j);
                }
                baos.close();
            }
        }
    }
}