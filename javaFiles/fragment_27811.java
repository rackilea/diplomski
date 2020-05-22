import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;

/** Small test application used to fetch a map. */
public class FetchMapSwingApp extends JFrame {
   /** Serial Id. */
   private static final long serialVersionUID = 1920071939468904323L;

   /**
    * Default constructor.
    */
   public FetchMapSwingApp() {
      // Make sure the application closes correctly
      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      // The map where trying to read
      String url = "http://maps.googleapis.com/maps/api/staticmap?center=55.690815,12.560678&zoom=15&size=400x500&sensor=false";
      // Fetch the image
      Image image = fetchMap(url);

      // Add the image to the JFrame and resize the frame.
      add(new JLabel(new ImageIcon(image)));
      pack();
   }

   /**
    * Fetch the image on the given URL.
    * 
    * @param url
    *            the image location
    * @return the fetched image
    */
   private Image fetchMap(String url) {
      Image image = null;
      WebClient webClient = new WebClient();
      webClient.setThrowExceptionOnScriptError(false);

      try {
         // The URL returns a png file!
         UnexpectedPage page = webClient.getPage(url);
         InputStream inputStream = page.getInputStream();
         // Read the stream to an image
         image = ImageIO.read(inputStream);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return image;
   }

   /**
    * Start of the application.
    * 
    * @param args
    *            the arguments to the main method
    */
   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            new FetchMapSwingApp().setVisible(true);
         }
      });
   }
}