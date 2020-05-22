import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public final class fff {
    private static Robot robot;
    public static boolean clickStatus;

    public static void leftClick(int R, int G, int B) {
        Color myColorToMatch = new Color(R, G, B);
        BufferedImage image = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        int[] rgbs = new int[w * h];
        image.getRGB(0, 0, w, h, rgbs, 0, w);
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (new Color(image.getRGB(x, y)).equals(myColorToMatch)) {
                    robot.mouseMove(x, y);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            robot = new Robot();
        } catch (Exception Error) {
            Error.printStackTrace();
        }
        // dImp: 130,40,32 - 160,99,57 - 217,135,79
        // banker: 139, 130, 129
        boolean botLoop = true;
        while (botLoop == true) {
            robot.delay(1000);
            leftClick(0, 0, 0);
            break; //no lop
        }
    }
}