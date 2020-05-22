import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import org.apache.poi.xslf.usermodel.*;

public class UnicodePPT {
    public static void main(String[] args) throws Exception {
        // create a sample pptx
        XMLSlideShow ss = new XMLSlideShow();
        Dimension pgsize = ss.getPageSize();             

        XSLFSlide slide = ss.createSlide();
        XSLFTextBox tb = slide.createTextBox();
        tb.setShapeType(XSLFShapeType.HEART);
        int shapeSize = 150;
        tb.setAnchor(new Rectangle2D.Double(pgsize.getWidth()/2-shapeSize/2, pgsize.getHeight()/2-shapeSize/2, shapeSize, shapeSize));
        tb.setLineWidth(2);
        tb.setLineColor(Color.BLACK);
        XSLFTextParagraph par = tb.addNewTextParagraph();
        tb.setVerticalAlignment(VerticalAlignment.DISTRIBUTED);
        par.setTextAlign(TextAlign.CENTER);
        XSLFTextRun run = par.addNewTextRun();
        run.setText("/\u02CCin\u0259\u02C8v\u0101SH\u0259n/");
        run.setFontFamily("DejaVu Serif");
        run.setFontSize(12);
        par.addLineBreak();
        run = par.addNewTextRun();
        run.setText("/\u02CCin\u0259\u02C8v\u0101SH\u0259n/");
        run.setFontFamily("GE Inspira");
        run.setFontSize(12);

        // set the font
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        InputStream is = new FileInputStream("src/main/resources/GEInspRg.TTF");
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        is.close();
        ge.registerFont(font);  

        is = new FileInputStream("src/main/resources/DejaVuSerif.ttf");
        font = Font.createFont(Font.TRUETYPE_FONT, is);
        is.close();
        ge.registerFont(font);  

        // render it
        double zoom = 2; // magnify it by 2
        AffineTransform at = new AffineTransform();
        at.setToScale(zoom, zoom);

        BufferedImage img = new BufferedImage((int)Math.ceil(pgsize.width*zoom), (int)Math.ceil(pgsize.height*zoom), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setTransform(at);                
        graphics.setPaint(Color.white);
        graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
        slide.draw(graphics);             

        FileOutputStream fos = new FileOutputStream("unicodeppt.png");
        javax.imageio.ImageIO.write(img, "png", fos);       
        fos.close();
    }
}