class ImageDetector implements RenderListener {
    public void beginTextBlock() { }
    public void endTextBlock() { }
    public void renderText(TextRenderInfo renderInfo) { }

    public void renderImage(ImageRenderInfo renderInfo) {
        imageFound = true;
    }

    boolean imageFound = false;
}