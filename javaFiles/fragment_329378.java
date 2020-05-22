import java.net.MalformedURLException;
import java.net.URL;

import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;

class CheckResolution {
  String imageURL = "test.png";

  public static void main(String[] args) throws MalformedURLException {
     CheckResolution cr = new CheckResolution();
     URL imageurl = new URL(cr.imageURL);
     PlanarImage pi = JAI.create("url", imageurl);
     int imagewidth = pi.getWidth();
     int imageheight = pi.getHeight();
     System.out.println("Image Width:" + imagewidth + " --- Image Height:" + imageheight);
  }
}