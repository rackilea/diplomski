import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class RotateImage extends Applet {

private Image image;

AffineTransform identity = new AffineTransform();

 private URL getURL(String filename) {
 URL url = null;
 try {
 url = this.getClass().getResource(filename);
 }
catch(Exception e){}
return url;
}

public void init() {
image = getImage(getCodeBase(), "image.jpg");
}

public void paint(Graphics g) {
Graphics2D g2d = (Graphics2D)g;
AffineTransform trans = new AffineTransform();
trans.setTransform(identity);
trans.rotate( Math.toRadians(45) );
g2d.drawImage(image, trans, this);
}
}