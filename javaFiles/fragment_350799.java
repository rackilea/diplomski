import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.awt.geom.*;

public class Testing {
    public static void main(String[] args) throws Exception {

        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 400, 400);

        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        for (int i=0; i<400; i+=5)
        {
            double dy = 8.0*(i-100.0) / 200.0;
            g.setColor(Color.BLACK);
            g.draw(new Line2D.Double(-100, dy+i, 90, i));
            g.draw(new Line2D.Double(200+-100, dy+i, 200+90, i));
        }

        g.dispose();
        ImageIO.write(image, "png", new File("output.png"));
    }
}