import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class BufferedImageTest {

    public static void main(String[] args) {
        try {
            BufferedImage transparent = ImageIO.read(new URL("http://upload.wikimedia.org/wikipedia/commons/4/4a/Logo_2013_Google.png"));
            System.out.println(transparent.getType());
            BufferedImage solid = ImageIO.read(new URL("http://blacklabelsociety.com/home/wp-content/uploads/2014/01/spacer.jpg"));
            System.out.println(solid.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}