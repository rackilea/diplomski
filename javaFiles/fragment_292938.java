import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class SplashScreen100 extends Frame implements ActionListener {

    static ArrayList<Image> imgs;

    private static final long serialVersionUID = 1L;
    private BufferedImage background;

    protected void renderSplashFrame(Graphics2D g, Image bg) {

        // Get the splash screen size...
        Dimension size = SplashScreen.getSplashScreen().getSize();
        int width = size.width;
        int height = size.height;

        // Center the image within the splash screen
        int x = (width - bg.getWidth(null)) / 2;
        int y = (height - bg.getHeight(null)) / 2;
        Graphics2D g2d = (Graphics2D) g.create();

        // Draw the background
        g2d.drawImage(background, 0, 0, null);
        // Apply alpha composite
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        // Draw the image...
        g2d.drawImage(bg, x, y, null);
        g2d.dispose();
    }

    public SplashScreen100() {
        super("SplashScreen demo");
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }

        try {
            background = ImageIO.read(splash.getImageURL());

            for (Image img : imgs) {
                renderSplashFrame(g, img);
                splash.update();
                // I put this in to slow the updates down...
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SplashScreen100.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        splash.close();
    }

    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

    public static void main(String args[]) {
        System.setProperty("sun.java2d.opengl", "True");
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();

        imgs = new ArrayList<Image>();
        for (File file : new File("\path\to\images").listFiles()) {
            if (file.getName().toLowerCase().endsWith(".png")) {
                try {
                    Image buffy = ImageIO.read(file);
                    imgs.add(buffy);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        SplashScreen100 test = new SplashScreen100();
    }

}