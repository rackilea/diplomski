import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

public class WrapImage {

    /**
     * Get position where string will break
     * @param text, the text
     * @param width, the width of the component
     * @param height, the height of the component
     * @return the position
     */
    public static int getBreakPosition(String text, int width, int height){
        //Start font context
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);     

        //Set same font as used in jasper-report
        Font font = new Font("SansSerif", Font.PLAIN, 10);
        //Get height to understand how many lines
        double textheight = font.getStringBounds(text, frc).getHeight();
        int nrLines = (int)Math.floor(height/textheight);

        //init variables
        int breakPos = 0;
        int line = 1;

        //loop the lines
        while (line<=nrLines){
            //get remaining text
            String textPart = text.substring(breakPos,text.length());
            //get how much text will fit in line
            breakPos += getLineBreakPosition(textPart, width, font, frc)+1;
            line++;
        }

        return breakPos;

    }

    /**
     * Get where a single line will break
     * @param text, the text
     * @param width, width of component
     * @param font, the font used
     * @param frc, the FontRenderContext
     * @return
     */
    protected static int getLineBreakPosition(String text, int width, Font font, FontRenderContext frc){
        int breakPos  = 0;
        String tmpText = text;
        while (font.getStringBounds(tmpText, frc).getWidth()>width){
            //the break position is space
            breakPos = tmpText.lastIndexOf(' ');
            if (breakPos<=0){
                breakPos = 0;
                break;
            }
            tmpText = tmpText.substring(0,breakPos);
        }
        return breakPos;
    }
}