public class FontStyle {
    final int BOLD = 1;
    final int ITALIC = 2;
    final int UNDERLINED = 4;

    private int fontStyle;

    public void setFontStyle(int style) {
       this.fontStyle = fontStyle;
    }

    public boolean hasStyle(int style) {
       return fontStyle & style == style;
    }
}