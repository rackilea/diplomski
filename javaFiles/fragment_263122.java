import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;

public class FontUtilities
{   
    public static Font createFontToFit
    (
        String value,
        double width,
        double height,
        Font base,
        Graphics context
    )
    {
        double measuredWidth;
        double measuredHeight;
        double baseFontSize;
        FontMetrics ruler;
        Rectangle2D bounds;
        double heightBasedFontSize;
        double widthBasedFontSize;
        GlyphVector vector;
        Shape outline;

        if
        (
            (value == null) ||
            (base == null) ||
            (context == null) ||
            (width != width) ||
            (height != height)
        )
        {
            return null;
        }

        //measure the size of the string in the current font size
        baseFontSize = base.getSize2D();
        ruler = context.getFontMetrics(base);


        vector = base.createGlyphVector(ruler.getFontRenderContext(), value);

        //use the bounds measurement on the outline of the text since this is the only
        //measurement method that seems to be bug free and consistent in java
        outline = vector.getOutline(0, 0);
        bounds = outline.getBounds();

        measuredWidth = bounds.getWidth();
        measuredHeight = bounds.getHeight();

        //assume that each of the width and the height of the string
        //is proportional to the font size, calculate the ratio
        //and extrapolate linearly to determine the needed font size.
        //should have 2 font sizes one for matching the width, and one for
        //matching the height, return the least of the 2
        widthBasedFontSize = (baseFontSize*width)/measuredWidth;
        heightBasedFontSize = (baseFontSize*height)/measuredHeight;

        if(widthBasedFontSize < heightBasedFontSize)
        {
            return base.deriveFont(base.getStyle(), (float)widthBasedFontSize);
        }
        else
        {
            return base.deriveFont(base.getStyle(), (float)heightBasedFontSize);
        }
    }
}