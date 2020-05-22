public interface RenderListener {
    /**
     * Called when a new text block is beginning (i.e. BT)
     */
    public void beginTextBlock();

    /**
     * Called when text should be rendered
     * @param renderInfo information specifying what to render
     */
    public void renderText(TextRenderInfo renderInfo);

    /**
     * Called when a text block has ended (i.e. ET)
     */
    public void endTextBlock();

    /**
     * Called when image should be rendered
     * @param renderInfo information specifying what to render
     */
    public void renderImage(ImageRenderInfo renderInfo);
}