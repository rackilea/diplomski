public void renderText(TextRenderInfo renderInfo)
{
    DocumentFont documentFont = renderInfo.getFont();
    PdfDictionary font = documentFont.getFontDictionary();
    // Check the font dictionary like in your example code
    if (font FULFILLS SOME CRITERIA)
    {
        // The text
        String text = renderInfo.getText();
        // is rendered on the current page on the base line
        LineSegment baseline = renderInfo.getBaseline();
        // using a font fulfilling the given criteria
        ...
    }
}