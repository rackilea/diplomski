import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleAppletImage extends JApplet {
   @Override
   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               try {
                  // you might want to use a file in place of a URL here
                  URL url = new URL("http://duke.kenai.com/gun/Gun.jpg");
                  BufferedImage img = ImageIO.read(url);
                  MyPanel myPanel = new MyPanel(img );
                  getContentPane().add(myPanel);
               } catch (MalformedURLException e) {
                  e.printStackTrace();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         });
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}