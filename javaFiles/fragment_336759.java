import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Simple splash screen, contains only the image.
 * 
 * @author m4tx3
 */
public class SplashScreen extends JFrame {

    /**
     * Constructor. Creates a window with splash screen, loads an image at the URL specified in imageURL, and finally displays this image.
     * 
     * @param imageURL
     *            URL to the image that you want to put on the splash screen.
     */
    public SplashScreen() {
        super("Splash screen");
    }

    public void createSplashScreen(final URL imageURL) {

        JLabel splashLabel = new JLabel(new ImageIcon(imageURL));
        add(splashLabel);
            setSize(splashLabel.getPreferredSize());
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);

        repaint();
    }

    /**
     * Closes the splash screen and frees the memory taken by the image.
     * 
     * Call this function when the loading is complete.
     */
    public void close() {
        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new SplashScreen().createSplashScreen(new URL(
                            "http://art.gnome.org/download/themes/splash_screens/1334/Splash-GnomeDarkSplashScreen.png"));
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}