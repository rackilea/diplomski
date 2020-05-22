import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Composite;

/**
 * The class used for writing an {@link Composite} to an image file
 * 
 * @author David L. Moffett
 * 
 */
public class CompositeImageWriter
{
  /**
   * Redraws the composite to the desired size off-screen and then writes that
   * composite as an image to the desired location and in the desired format
   * 
   * @param absolutePath
   *          the absolute path to the desired output file
   * @param compositeToDraw
   *          the composite to be written to file as an image
   * @param width
   *          the desired width in pixels that the composite should be redrawn
   *          to
   * @param height
   *          the desired height in pixels that the composite should be redrawn
   *          to
   * @param imageType
   *          an int representing the type of image that should be written
   */
  public static void drawComposite(String absolutePath, Composite compositeToDraw, int width,
      int height, int imageType)
  {
    Image image = new Image(compositeToDraw.getDisplay(), width, height);
    GC gc = new GC(image);
    int originalWidth = compositeToDraw.getBounds().width;
    int originalHeight = compositeToDraw.getBounds().height;
    compositeToDraw.setSize(width, height);
    compositeToDraw.print(gc);
    compositeToDraw.setSize(originalWidth, originalHeight);

    ImageLoader loader = new ImageLoader();
    loader.data = new ImageData[] { image.getImageData() };
    loader.save(absolutePath, imageType);

    image.dispose();
    gc.dispose();
  }
}