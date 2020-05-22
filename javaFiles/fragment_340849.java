void addUserPatternOverAndUnder(File source, File target) throws IOException, DocumentException
{
    PdfReader reader = new PdfReader(source.getPath());
    OutputStream os = new FileOutputStream(target);
    PdfStamper stamper = new PdfStamper(reader, os);

    Rectangle pageSize = reader.getPageSize(1);
    final float WATERMARK_PAGE_ANGLE = -60;

    BaseFont font = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);

    PdfPatternPainter painter = stamper.getOverContent(1).createPattern(pageSize.getWidth(),
            pageSize.getHeight());
    painter.setColorStroke(new BaseColor(0, 192, 192));
    painter.setLineWidth(0.85f);
    painter.setLineDash(0.4f, 0.4f, 0.2f);

    painter.beginText();
    painter.setTextRenderingMode(PdfPatternPainter.TEXT_RENDER_MODE_STROKE);
    painter.setFontAndSize(font, 42);
    painter.showTextAlignedKerned(Element.ALIGN_MIDDLE, "user name must required", 150, 780,
            WATERMARK_PAGE_ANGLE);
    painter.showTextAlignedKerned(Element.ALIGN_MIDDLE, "user Company name required", 100, 730,
            WATERMARK_PAGE_ANGLE);
    painter.showTextAlignedKerned(Element.ALIGN_MIDDLE, "Plesae enter your email id", 050, 680,
            WATERMARK_PAGE_ANGLE);
    painter.endText();

    for (int i = reader.getNumberOfPages(); i > 0; i--)
    {
        Rectangle thisPageSize = reader.getPageSize(i);

        PdfContentByte underContent = stamper.getUnderContent(i);
        underContent.setColorFill(new PatternColor(painter));
        underContent.rectangle(thisPageSize.getLeft(), thisPageSize.getBottom(), thisPageSize.getWidth(),
                thisPageSize.getHeight());
        underContent.fill();

        List<Vector> path = getImageBordersPathPoints(reader, i);
        if (path != null && !path.isEmpty())
        {
            PdfContentByte overContent = stamper.getOverContent(i);
            overContent.setColorFill(new PatternColor(painter));

            for (int index = 0; index < path.size(); index++)
            {
                Vector corner = path.get(index);
                if (index % 4 == 0)
                {
                    overContent.moveTo(corner.get(Vector.I1), corner.get(Vector.I2));
                }
                else
                {
                    overContent.lineTo(corner.get(Vector.I1), corner.get(Vector.I2));
                    if (index % 4 == 3)
                    {
                        overContent.closePath();
                    }
                }
            }
            overContent.fill();
        }
    }

    stamper.close();
    os.close();
    reader.close();
}

static Vector A = new Vector(0, 0, 1);
static Vector B = new Vector(1, 0, 1);
static Vector C = new Vector(1, 1, 1);
static Vector D = new Vector(0, 1, 1);
static List<Vector> positive = Arrays.asList(A, B, C, D);
static List<Vector> negative = Arrays.asList(A, D, C, B);

List<Vector> getImageBordersPathPoints(PdfReader reader, int page) throws IOException
{
    final List<Vector> result = new ArrayList<Vector>();
    RenderListener listener = new RenderListener()
    {
        public void renderText(TextRenderInfo renderInfo)
        {
        }

        public void endTextBlock()
        {
        }

        public void beginTextBlock()
        {
        }

        public void renderImage(ImageRenderInfo renderInfo)
        {
            Matrix ctm = renderInfo.getImageCTM();
            List<Vector> unitCorners = ctm.getDeterminant() > 0 ? positive : negative;

            for (Vector corner : unitCorners)
            {
                result.add(corner.cross(ctm));
            }
        }
    };

    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
    parser.processContent(page, listener);
    return result;
}