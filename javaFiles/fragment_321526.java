public class PdfContentStreamEditor extends PDFGraphicsStreamEngine {
    public PdfContentStreamEditor(PDDocument document, PDPage page) {
        super(page);
        this.document = document;
    }

    /**
     * <p>
     * This method retrieves the next operation before its registered
     * listener is called. The default does nothing.
     * </p>
     * <p>
     * Override this method to retrieve state information from before the
     * operation execution.
     * </p> 
     */
    protected void nextOperation(Operator operator, List<COSBase> operands) {

    }

    /**
     * <p>
     * This method writes content stream operations to the target canvas. The default
     * implementation writes them as they come, so it essentially generates identical
     * copies of the original instructions {@link #processOperator(Operator, List)}
     * forwards to it.
     * </p>
     * <p>
     * Override this method to achieve some fancy editing effect.
     * </p> 
     */
    protected void write(ContentStreamWriter contentStreamWriter, Operator operator, List<COSBase> operands) throws IOException {
        contentStreamWriter.writeTokens(operands);
        contentStreamWriter.writeToken(operator);
    }

    // stub implementation of PDFGraphicsStreamEngine abstract methods
    @Override
    public void appendRectangle(Point2D p0, Point2D p1, Point2D p2, Point2D p3) throws IOException { }

    @Override
    public void drawImage(PDImage pdImage) throws IOException { }

    @Override
    public void clip(int windingRule) throws IOException { }

    @Override
    public void moveTo(float x, float y) throws IOException { }

    @Override
    public void lineTo(float x, float y) throws IOException { }

    @Override
    public void curveTo(float x1, float y1, float x2, float y2, float x3, float y3) throws IOException { }

    @Override
    public Point2D getCurrentPoint() throws IOException { return null; }

    @Override
    public void closePath() throws IOException { }

    @Override
    public void endPath() throws IOException { }

    @Override
    public void strokePath() throws IOException { }

    @Override
    public void fillPath(int windingRule) throws IOException { }

    @Override
    public void fillAndStrokePath(int windingRule) throws IOException { }

    @Override
    public void shadingFill(COSName shadingName) throws IOException { }

    // PDFStreamEngine overrides to allow editing
    @Override
    public void processPage(PDPage page) throws IOException {
        PDStream stream = new PDStream(document);
        replacement = new ContentStreamWriter(replacementStream = stream.createOutputStream(COSName.FLATE_DECODE));
        super.processPage(page);
        replacementStream.close();
        page.setContents(stream);
        replacement = null;
        replacementStream = null;
    }

    @Override
    public void showForm(PDFormXObject form) throws IOException {
        // DON'T descend into XObjects
        // super.showForm(form);
    }

    @Override
    protected void processOperator(Operator operator, List<COSBase> operands) throws IOException {
        nextOperation(operator, operands);
        super.processOperator(operator, operands);
        write(replacement, operator, operands);
    }

    final PDDocument document;
    OutputStream replacementStream = null;
    ContentStreamWriter replacement = null;
}