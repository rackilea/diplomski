public class JRSplitText {

    public static JRDataSource getTextDataSource(String text, int wrappingWidth, String fontName, int fontStyle, int fontSize) {
        // Our list with the different text segements (lines)
        List<String> textSegements = new ArrayList<>();

        // Instance a FontRenderContext
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

        // Instance the AttributedString and it's iterator
        AttributedString attrText = new AttributedString(text);
        // To consider font-extensions lets load font directly from jasper-reports
        FontUtil fontUtil = FontUtil.getInstance(DefaultJasperReportsContext.getInstance());
        Font font = fontUtil.getAwtFontFromBundles(fontName, fontStyle, fontSize, Locale.getDefault(), false);
        attrText.addAttribute(TextAttribute.FONT, font);
        AttributedCharacterIterator styledText = attrText.getIterator();

        // Start measurer how much text can fit in our width and add each line
        // to our list
        LineBreakMeasurer measurer = new LineBreakMeasurer(styledText, frc);
        while (measurer.getPosition() < styledText.getEndIndex()) {
            TextLayout layout = measurer.nextLayout(wrappingWidth);
            String line = text.substring(measurer.getPosition() - layout.getCharacterCount(), measurer.getPosition());
            textSegements.add(line);
        }

        // return a datasource of our lists
        return new JRBeanCollectionDataSource(textSegements);
    }
}