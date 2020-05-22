import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.Random;

public class MoveMouse {

    private static final Robot ROBOT;
    private static final Random RNG;

    public static void main(String[] args) {
        // grab the screen size
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // Equivalent to 'new Rectangle(0, 0, screen.width, screen.height)' 
        Rectangle boundary  = new Rectangle(screen);
        // move anywhere on screen
        moveMouse(boundary);
    }

    public static void moveMouse(int x, int y, int radiusX, int radiusY) {
        Rectangle boundary = new Rectangle();
        // this will be our center
        boundary.setLocation(x, y);
        // grow the boundary from the center
        boundary.grow(radiusX, radiusY);
        moveMouse(boundary);
    }

    public static void moveMouse(Rectangle boundary) {
        // add 1 to the width/height, nextInt returns an exclusive random number (0 to (argument - 1))
        int x = boundary.x + RNG.nextInt(boundary.width + 1);
        int y = boundary.y + RNG.nextInt(boundary.height + 1);
        ROBOT.mouseMove(x, y);
    }

    // initialize the robot/random instance once when the class is loaded
    // and throw an exception in the unlikely scenario when it can't 
    static {
        try {
            ROBOT = new Robot();
            RNG = new Random();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}