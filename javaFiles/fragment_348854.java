import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class FilePrinter 
{
public static void main(String[] args) {
    try {
        Robot robot = new Robot();
        Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
        ImageIO.write(bufferedImage, "png", new File("c:/temp/test.png"));
    }
    catch(Exception e) {
        System.err.println("Someone call a doctor!");
    }

}
}