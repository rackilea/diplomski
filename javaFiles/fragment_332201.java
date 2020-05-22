private static class AnnotationRenderer extends AbstractRenderer implements ILeafElementRenderer {
    private PdfAnnotation annotation;

    public AnnotationRenderer(PdfAnnotation annotat) {
        this.annotation = annotat;
    }

    @Override
    public float getAscent() {
        return annotation.getRectangle().toRectangle().getHeight();
    }

    @Override
    public float getDescent() {
        return 0;
    }

    @Override
    public LayoutResult layout(LayoutContext layoutContext) {
        occupiedArea = layoutContext.getArea().clone();

        float myHeight = annotation.getRectangle().toRectangle().getHeight();
        float myWidth = annotation.getRectangle().toRectangle().getWidth();
        occupiedArea.getBBox().moveUp(occupiedArea.getBBox().getHeight() - myHeight).setHeight(myHeight);
        occupiedArea.getBBox().setWidth(myWidth);

        return new LayoutResult(LayoutResult.FULL, occupiedArea, null, null);
    }

    @Override
    public void draw(DrawContext drawContext) {
        super.draw(drawContext);
        annotation.setRectangle(new PdfArray(occupiedArea.getBBox()));
        drawContext.getDocument().getPage(occupiedArea.getPageNumber()).addAnnotation(annotation);
    }

    @Override
    public IRenderer getNextRenderer() {
        return new AnnotationRenderer(annotation);
    }
}