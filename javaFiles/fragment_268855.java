public ParagraphRenderer addParagraphToPage(PdfDocument pdfDocument, int pageNum, Rectangle rectangle, ParagraphRenderer renderer) {
    PdfPage page = pdfDocument.getPage(pageNum);
    PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamAfter(), page.getResources(), pdfDocument);
    Canvas canvas = new Canvas(pdfCanvas, pdfDocument, rectangle);

    renderer.setParent(canvas.getRenderer());
    LayoutResult result = renderer.layout(new LayoutContext(new LayoutArea(pageNum, rectangle)));

    IRenderer rendererToAdd = result.getStatus() == LayoutResult.FULL ? renderer : result.getSplitRenderer();

    canvas.getRenderer().addChild(rendererToAdd.setParent(canvas.getRenderer()));

    return result.getStatus() != LayoutResult.FULL ? (ParagraphRenderer) result.getOverflowRenderer() : null;
}