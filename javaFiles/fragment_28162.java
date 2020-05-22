import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.*;

@XmlRootElement
@XmlType(propOrder = {"font", "fontColor", "backgroundColor"}) // to keep ordering consistent with "example.xml"
public class FontStyle {

    private Font font;

    private Color fontColor = Color.BLACK;

    private Color backgroundColor = Color.WHITE;

    public FontStyle() {
    }

    public FontStyle(Font font, Color fontColor, Color backgroundColor) {
        this.font = font;
        this.fontColor = fontColor;
        this.backgroundColor = backgroundColor;
    }

    @XmlJavaTypeAdapter(FontAdapter.class)
    public Font getFont() {
        return font;
    }

    @XmlJavaTypeAdapter(ColorAdapter.class)
    public Color getFontColor() {
        return fontColor;
    }

    @XmlJavaTypeAdapter(ColorAdapter.class)
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    private static class ColorAdapter extends XmlAdapter<ColorAdapter.ColorValueType, Color> {

        @Override
        public Color unmarshal(ColorValueType v) throws Exception {
            return new Color(v.red, v.green, v.blue);
        }

        @Override
        public ColorValueType marshal(Color v) throws Exception {
            return new ColorValueType(v.getRed(), v.getRed(), v.getBlue());
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class ColorValueType {
            private int red;
            private int green;
            private int blue;

            public ColorValueType() {
            }

            public ColorValueType(int red, int green, int blue) {
                this.red = red;
                this.green = green;
                this.blue = blue;
            }
        }
    }

    private static class FontAdapter extends XmlAdapter<FontAdapter.FontValueType, Font> {

        @Override
        public Font unmarshal(FontValueType v) throws Exception {
            return new Font(v.family, v.style, v.size);
        }

        @Override
        public FontValueType marshal(Font v) throws Exception {
            return new FontValueType(v.getFamily(), v.getStyle(), v.getSize());
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class FontValueType {
            private String family;
            private int style;
            private int size;

            public FontValueType() {
            }

            public FontValueType(String family, int style, int size) {
                this.family = family;
                this.style = style;
                this.size = size;
            }
        }
    }
}