import java.awt.*;
import javax.swing.*;

public class MultiMonitorFrame extends JFrame {

    public static void showFrameOnScreen(Window frame, int screen) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
        GraphicsDevice graphicsDevice = ( screen > -1 && screen < graphicsDevices.length ) ? graphicsDevices[screen] : graphicsDevices.length > 0 ? graphicsDevices[0] : null;
        if (graphicsDevice == null)
        {
            throw new RuntimeException( "There are no screens !" );
        }
        Rectangle bounds = graphicsDevice.getDefaultConfiguration().getBounds();
        frame.setSize(bounds.width, bounds.height);
        frame.setLocation(bounds.x, bounds.y);
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("First frame");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setAlwaysOnTop(true);
        JFrame frame2 = new JFrame("Second frame");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        frame2.setAlwaysOnTop(true);
        showFrameOnScreen(frame1, 1);
        showFrameOnScreen(frame2, 2);
    }
}