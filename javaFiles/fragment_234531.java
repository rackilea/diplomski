import java.util.Iterator;

// for Picture and Sound etc.
import Media.Picture;
import Media.PictureDisplayer;
import Media.Pixel;

/**
 * This class ...
 *
 * @author <your name>
 * @version 1.0 (<date>)
 */

public class Brighten
{
    private PictureDisplayer display;
    private Picture pic;

    public Brighten()
    {
        display = new PictureDisplayer();
        pic = new Picture();
        display.placePicture(pic);
        display.waitForUser();
        normIntensity(pic);
        display.close();
    }; // constructor

    private int maxChannel(Picture img)
    {
        Pixel m;
        int red;
        int blue;
        int green;

        int max = 0;

        while (img.hasNext())
        {
            m = img.next();

            red = m.getRed();
            blue = m.getBlue();
            green = m.getGreen();

            if ((red >= blue) && (red >= green) && (red >= max))
            {
                max = red;
            }
            if ((blue >= red) && (blue >= green) && (blue >= max))
            {
                max = blue;
            }
            if ((green >= red) && (green >= blue) && (green >= max))
            {
                max = green;
            }
        }
        return max;
    }

    private void normIntensity(Picture img)
    {
        // Compute the maximum value of any channel over ALL pixels:
        int max = maxChannel(img);

        // Nothing to do if the image is all black...
        if (max == 0)
            return;

        // Compute the multiplier. This should probably be a double value:
        double multi = 255.0 / max;

        // Use the multiplier to scale all pixels
        Iterator<Pixel> iterator = img.iterator();
        while (iterator.hasNext())
        {
            Pixel a = iterator.next();

            int r = a.getRed();
            int g = a.getGreen();
            int b = a.getBlue();

            a.setRed((int) (multi * r));
            a.setGreen((int) (multi * g));
            a.setBlue((int) (multi * b));
        }
    };

    public static void main(String[] args)
    {
        Brighten s = new Brighten();
    };
} // <className>