/**
 * Strategy to render some text, of two size variants, centered horizontally
 * at a specified position.
 */
public interface TextRenderer {
    public enum FontSize { LARGE, SMALL };
    public void render(String text, int x, int y, FontSize size);
}

/**
 * TextRenderer Factory that uses the ScreenDimension to determine sizes of LARGE
 * and SMALL fonts to use.
 */
public class ScreenDimensionAwareTextRendererFactory {
    public static TextRenderer getTextRenderer(Graphics gc) {
        Font baseFont = Font.getDefault();
        int fontWidth = ScreenDimension.getFontWidth();
        return fontWidth == 320
                ? new DefaultTextRenderer(gc, baseFont.derive(Font.PLAIN,10,Ui.UNITS_pt), baseFont.derive(Font.PLAIN,6,Ui.UNITS_pt))
                : new DefaultTextRenderer(gc, baseFont.derive(Font.PLAIN,12,Ui.UNITS_pt), baseFont.derive(Font.PLAIN,8,Ui.UNITS_pt));
    }
}

public class DefaultTextRenderer implements TextRenderer {
    protected Map<FontSize,Font> fontSizeMap = new HashMap<FontSize,Font>();
    protected Graphics gc;
    public DefaultTextRenderer(Graphics gc, Font largeFont, Font smallFont) {
        this.gc = gc;
        fontSizeMap.put(LARGE, largeFont);
        fontSizeMap.put(SMALL, smallFont);        
    }
    public void render(String text, int x, int y, FontSize size) {
        Font font = fontSizeMap.get(size)
        int pixelWidth = font.getAdvance(text);
        gc.setFont(font);

        // TODO: note here I'm not dealing with the vertical offsets you're using
        // which are dependent upon the font size. It would be possible, but
        // I suspect what you really ought to be doing is consistently rendering
        // text on a baseline.
        // The way you could adjust this to closer match what you appear to be doing
        // would be to have arguments to render() which indicate vertical alignment.
        // something like 
        // TextRenderer.VerticalAlignment = enum { BASELINE, TOP, BOTTOM }
        // and based on something like that you could compute here the y offset
        // based on the selected font.
        // I can't do that now because you're "magic numbers" hard coded don't explain
        // what they're trying to do
        gc.drawText(text, Math.round(x - (pixelWidth / 2)), y);
    }
}

// your example
public void paint(Graphics graphics) {
    super.paint(graphics);

    String strScore = String.valueOf(score);
    TextRenderer textRenderer = ScreenDimensionAwareTextRendererFactory.getTextRenderer(graphics);
    int middleX = Math.round(this.backgroundBitmap.getWidth() / 2);
    textRenderer.render(strScore, middleX, 10, TextRenderer.TextSize.LARGE);
    textRenderer.render(judgeName, middleX, this.backgroundBitmap.getHeight(), TextRenderer.TextSize.SMALL);
}