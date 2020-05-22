package cmyk;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;

public class Main
{

    /**
     * Creates new RGB images from all the CMYK images passed
     * in on the command line.
     * The new filename generated is, for example "GIF_original_filename.gif".
     *
     */
    public static void main(String[] args)
    {
        for (int ii = 0; ii < args.length; ii++)
        {
            String filename = args[ii];
            boolean cmyk = isCMYK(filename);
            System.out.println(cmyk + ": " + filename);
            if (cmyk)
            {
                try
                {
                    String rgbFile = cmyk2rgb(filename);
                    System.out.println(isCMYK(rgbFile) + ": " + rgbFile);
                }
                catch (IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * If 'filename' is a CMYK file, then convert the image into RGB,
     * store it into a JPEG file, and return the new filename.
     *
     * @param filename
     */
    private static String cmyk2rgb(String filename) throws IOException
    {
        // Change this format into any ImageIO supported format.
        String format = "gif";
        File imageFile = new File(filename);
        String rgbFilename = filename;
        BufferedImage image = ImageIO.read(imageFile);
        if (image != null)
        {
            int colorSpaceType = image.getColorModel().getColorSpace().getType();
            if (colorSpaceType == ColorSpace.TYPE_CMYK)
            {
                BufferedImage rgbImage =
                    new BufferedImage(
                        image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
                ColorConvertOp op = new ColorConvertOp(null);
                op.filter(image, rgbImage);

                rgbFilename = changeExtension(imageFile.getName(), format);
                rgbFilename = new File(imageFile.getParent(), format + "_" + rgbFilename).getPath();
                ImageIO.write(rgbImage, format, new File(rgbFilename));
            }
        }
        return rgbFilename;
    }

    /**
     * Change the extension of 'filename' to 'newExtension'.
     *
     * @param filename
     * @param newExtension
     * @return filename with new extension
     */
    private static String changeExtension(String filename, String newExtension)
    {
        String result = filename;
        if (filename != null && newExtension != null && newExtension.length() != 0);
        {
            int dot = filename.lastIndexOf('.');
            if (dot != -1)
            {
                result = filename.substring(0, dot) + '.' + newExtension;
            }
        }
        return result;
    }

    private static boolean isCMYK(String filename)
    {
        boolean result = false;
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(new File(filename));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage() + ": " + filename);
        }
        if (img != null)
        {
            int colorSpaceType = img.getColorModel().getColorSpace().getType();
            result = colorSpaceType == ColorSpace.TYPE_CMYK;
        }

        return result;
    }
}