import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Cropper {

    public static void main(String[] args) throws IOException {
        BufferedImage src = ImageIO.read(new URL("https://www.citrix.com/blogs/wp-content/uploads/2015/02/Signature-Richard1.jpg"));
        int x0=src.getWidth();
        int y0=src.getHeight();
        int x1=0;
        int y1=0;
        //just a guess: the pixels color at 0,0 is wht you want to crop
        int unusedcolor=src.getRGB(0,0);
        //iterate over all pixels
        for (int y = 0; y < src.getHeight(); y++) {
            for (int x = 0; x < src.getWidth(); x++) {
                  int  clr   = src.getRGB(x, y);
                  if (clr!=unusedcolor)
                  {
                      //pixel is used, shift the new borders accordingly 
                      x0=Math.min(x0, x);
                      y0=Math.min(y0, y);
                      x1=Math.max(x1, x);
                      y1=Math.max(y1, y);
                  }
            }
        }
        if (x1>x0 && y1>y0)
        {
            BufferedImage dest = src.getSubimage(x0, y0, x1-x0,y1-y0);
            ImageIO.write(dest, "png", new File("out.png"));
            Runtime.getRuntime().exec("cmd /c start out.png");
        }

    }
}