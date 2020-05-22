package imageio.byteconversion;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class BufferedImageToBytes {

    private static void log(String s) {
        System.out.println(s);
    }

    private static String toByteString(int color) {
        // Perform a bitwise AND for convenience while printing. 
        // Otherwise Integer.toHexString() interprets values as integers and a negative byte 0xFF will be printed as "ffffffff"
        return Integer.toHexString(color & 0xFF);
    }

    public static void main(String[] args) throws IOException {

        // Load the image. This expects the image to be in the same package with this class 
        InputStream stream = BufferedImageToBytes.class.getResourceAsStream("test.png");
        BufferedImage image = ImageIO.read(stream);
        int iw = image.getWidth();
        int ih = image.getHeight();
        log("Image loaded succesfully, width=" + iw + " height=" + ih);
        stream.close();

        log("Image color model: " + image.getColorModel());
        log("Image sample model: " + image.getSampleModel());
        log("Image raster: " + image.getRaster());

        int bands = image.getSampleModel().getNumBands();
        log("Color bands: " + bands);
        if (bands != 4) {
            throw new RuntimeException("The image does not have 4 color bands. Are you sure this is a 32-bit image?");
        }

        int threshold = 199; // <-- decide your threshold here

        byte bytes[] = new byte[4 * iw * ih];
        int index = 0;

        // note that image is processed row by row top to bottom
        for(int y = 0; y < ih; y++) {
            for(int x = 0; x < iw; x++) {

                // returns a packed pixel where each byte is a color channel
                // order is the default ARGB color model
                int pixel = image.getRGB(x, y);

                // Get pixels
                int alpha = (pixel >> 24) & 0xFF;
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                // perform filtering here depending on threshold 
                if (red > threshold) {
                   red = 255;
                } else {
                    red = 0;
                }

                log("[" + x + "," + y + "]" + " Converting [" + Integer.toHexString(pixel)  + "] --> ["
                        + toByteString(red) + ", " + toByteString(green) + ", " 
                        + toByteString(blue) + ", " + toByteString(alpha)
                        + "]");

                bytes[index++] = (byte) red;
                bytes[index++] = (byte) green;
                bytes[index++] = (byte) blue;
                bytes[index++] = (byte) alpha;
           }
        }
    }
}