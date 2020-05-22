import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

public class Test {

    public Test() throws Exception {
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Test();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void initComponents() throws Exception {
        createAndShowTray();
    }

    private void createAndShowTray() throws Exception {
        //Check the SystemTray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        //retieve icon form url and scale it to 32 x 32
        final TrayIcon trayIcon = new TrayIcon(resizeImage(ImageIO.read(
                new URL("http://www.optical-illusions.in/illusions/blue_rotation_optical_illusion.jpg")), BufferedImage.TYPE_INT_ARGB, 32, 32));

        //get the system tray
        final SystemTray tray = SystemTray.getSystemTray();

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }

        trayIcon.displayMessage("Title", "MESSAGE HERE", TrayIcon.MessageType.ERROR); //THIS IS THE LINE THAT SHOULD SHOW THE MESSAGE

    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
}