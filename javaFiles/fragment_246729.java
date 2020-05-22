import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDCT
{
  public static void main(String[] args)
  {
    ImageIcon icon = new ImageIcon(args[0]);
    Image image = icon.getImage();
    int w = image.getWidth(null);
    int h = image.getHeight(null);
    GraphicsDevice gs = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    GraphicsConfiguration gc = gs.getDefaultConfiguration();
    BufferedImage img = gc.createCompatibleImage(w, h, Transparency.OPAQUE);
    img.getGraphics().drawImage(image, 0, 0, null);
    int[] rgb1 = new int[w*h];
    img.getRaster().getDataElements(0, 0, w, h, rgb1);
    double[] array = new double[w*h];

    for (int i=0; i<w*h; i++)
       array[i] = (double) (rgb1[i] & 0xFF);

    org.jtransforms.dct.DoubleDCT_2D tr = new org.jtransforms.dct.DoubleDCT_2D(w, h);
    tr.forward(array, true);

    for (int i=0; i<w*h; i++)
    {
       // Grey levels
       int val= Math.min((int) (array[i]+128), 255);
       rgb1[i] = (val <<16) | (val << 8) | val;
    }

    img.getRaster().setDataElements(0, 0, w, h, rgb1);
    icon = new ImageIcon(img);
    JFrame frame = new JFrame("FFT");
    frame.setBounds(20, 30, w, h);
    frame.add(new JLabel(icon));
    frame.setVisible(true);
  }