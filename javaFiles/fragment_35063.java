import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageToText {
    public static void main(String args[]) throws IOException {
        File file = new File("your file path.jpg");
        BufferedImage image = ImageIO.read(file);
        // Getting pixel color by position x=100 and y=40

        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int color = image.getRGB(j, i);

                // You can convert the colour to a readable format by changing
                // to following string. It is a 6 character hex
                // String clr = Integer.toHexString(color).substring(2);

                // Write this int value or string value to the text file
                // Add a comma or any other separator. Since it is always 6
                // characters long you can avoid using comma. It will save some
                // space.
            }
            // add a new line
        }
    }
}