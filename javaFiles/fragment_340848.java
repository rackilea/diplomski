void addUserPatternToOverContent(File source, File target) throws IOException, DocumentException
{
    PdfReader reader = new PdfReader(source.getPath());
    OutputStream os = new FileOutputStream(target);
    PdfStamper stamper = new PdfStamper(reader, os);

    Rectangle pageSize = reader.getPageSize(1);
    final float WATERMARK_PAGE_ANGLE = -72;

    BaseFont font = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);

    PdfPatternPainter painter = stamper.getOverContent(1).createPattern(pageSize.getWidth(), pageSize.getHeight());
    painter.setColorStroke(new BaseColor(192, 192, 192));
    painter.setLineWidth(0.85f);
    painter.setLineDash(0.4f, 0.4f, 0.2f);

    painter.beginText();
    painter.setTextRenderingMode(PdfPatternPainter.TEXT_RENDER_MODE_STROKE);
    painter.setFontAndSize(font, 42);
    painter.showTextAlignedKerned(Element.ALIGN_MIDDLE,
            "user name must required", 250, 780,
            WATERMARK_PAGE_ANGLE);
    painter.showTextAlignedKerned(Element.ALIGN_MIDDLE,
            "user Company name required", 200, 730,
            WATERMARK_PAGE_ANGLE);
    painter.showTextAlignedKerned(Element.ALIGN_MIDDLE,
            "Plesae enter your email id", 150, 680,
            WATERMARK_PAGE_ANGLE);
    painter.endText();

    for (int i = reader.getNumberOfPages(); i > 0; i--)
    {
        Rectangle thisPageSize = reader.getPageSize(i);
        PdfContentByte overContent = stamper.getOverContent(i);
        overContent.setColorFill(new PatternColor(painter));
        overContent.rectangle(thisPageSize.getLeft(), thisPageSize.getBottom(), thisPageSize.getWidth(), thisPageSize.getHeight());
        overContent.fill();
    }

    stamper.close();
    os.close();
    reader.close();
}