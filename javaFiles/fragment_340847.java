PdfPatternPainter painter = stamper.getOverContent(1).createPattern(200, 150);
    painter.setColorStroke(BaseColor.BLACK);
    painter.beginText();
    painter.setTextRenderingMode(PdfPatternPainter.TEXT_RENDER_MODE_STROKE);
    painter.setTextMatrix(AffineTransform.getTranslateInstance(0, 50));
    painter.setFontAndSize(BaseFont.createFont(), 100);
    painter.showText("Test");
    painter.endText();