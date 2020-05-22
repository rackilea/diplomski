class StyleAnalyzer implements RenderListener
{
    public void beginTextBlock()                        { }
    public void endTextBlock()                          { }
    public void renderImage(ImageRenderInfo renderInfo) { }

    public void renderText(TextRenderInfo renderInfo)
    {
        System.out.printf("%s - %d - %s - %s - %s\n",
            renderInfo.getBaseline().getStartPoint(),
            renderInfo.getTextRenderMode(),
            toString(renderInfo.getFillColor()),
            toString(renderInfo.getStrokeColor()),
            renderInfo.getText());
    }

    String toString(BaseColor color)
    {
        if (color instanceof CMYKColor)
        {
            CMYKColor cmyk = (CMYKColor) color;
            return String.format("CMYK[%3.1f %3.1f %3.1f %3.1f]",
                cmyk.getCyan(), cmyk.getMagenta(), cmyk.getYellow(), cmyk.getBlack());
        }
        return String.valueOf(color);
    }
}