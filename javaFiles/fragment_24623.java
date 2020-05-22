import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class ScalrTest {

    public static void main(String[] args) {
        File image = new File("myimage.png");
        File smallImage = new File("myimage_s.png"); // FORNOW: added the file extension just to check the result a bit more easily
        // FORNOW: added print statements just to be doubly sure where we're reading from and writing to
        System.out.println(image.getAbsolutePath());
        System.out.println(smallImage.getAbsolutePath());
        try {
            BufferedImage bufimage = ImageIO.read(image);

            BufferedImage bISmallImage = Scalr.resize(bufimage, 30); // after this line my dimensions in bISmallImage are correct!
            ImageIO.write(bISmallImage, "png", smallImage); // but my smallImage has the same dimension as the original foto
        } catch (Exception e) {
            System.out.println(e.getMessage()); // FORNOW: added just to be sure
        }
    }

}