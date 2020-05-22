public static class DocumentAttributes
{
    private static SimpleAttributeSet font;
    private static SimpleAttributeSet boldFont;

    public static SimpleAttributeSet getFont()
    {
        if (font != null)
            return font;

        font = new SimpleAttributeSet()    
        StyleConstants.setFontFamily(font, "SansSerif");
        StyleConstants.setFontSize(font, 16);

        return font;
    }

    public static SimpleAttributeSet getBoldFont()
    {
        if (boldFont != null)
            return boldFont;

        boldfont = new SimpleAttributeSet( getFont() );    
        StyleConstants.setBold(boldFont, true);

        return boldFont;
    }

}