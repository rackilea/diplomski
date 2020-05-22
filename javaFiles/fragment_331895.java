public static void addWatermark(PdfDocument pdfDocument, String text) throws Exception {
        PdfFont font = PdfFontFactory.createFont();

        PdfExtGState gs1 = new PdfExtGState();
        gs1.setFillOpacity(0.2f);

        for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++) {
            PdfPage page = pdfDocument.getPage(i);
            float fontSize = Math.min(page.getPageSize().getWidth(), page.getPageSize().getHeight()) / 12;
            Paragraph p = new Paragraph(text)
                    .setFontColor(ColorConstants.LIGHT_GRAY, 0.2f).setFont(font).setFontSize(fontSize);
            PdfCanvas under = new PdfCanvas(page.newContentStreamBefore(), new PdfResources(), pdfDocument);
            under.setExtGState(gs1);
            new Canvas(under, pdfDocument, pdfDocument.getDefaultPageSize())
                    .showTextAligned(p,
                            page.getPageSize().getWidth() / 2,
                            page.getPageSize().getHeight() / 2,
                            1, TextAlignment.CENTER, VerticalAlignment.TOP, 0);
        }

        pdfDocument.close();
}