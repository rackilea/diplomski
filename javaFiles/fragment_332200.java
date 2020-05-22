private static class AnnotationElement extends AbstractElement<AnnotationElement> implements ILeafElement {
    private PdfAnnotation annotation;

    public AnnotationElement(PdfAnnotation annotation) {
        this.annotation = annotation;
    }

    @Override
    protected IRenderer makeNewRenderer() {
        return new AnnotationRenderer(annotation);
    }
}