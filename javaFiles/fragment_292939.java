import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static splashscreen.MySplashScreen.createCompatibleImage;
import static splashscreen.MySplashScreen.getGraphicsConfiguration;

public class DifferentSplashScreen {

    public static void main(String[] args) {
        new DifferentSplashScreen();
    }

    public DifferentSplashScreen() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JWindow frame = new JWindow();
                frame.setAlwaysOnTop(true);
                frame.setLayout(new BorderLayout());
                frame.add(new SplashPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SplashPane extends JPanel {

        private BufferedImage background;
        private List<BufferedImage> frames;
        private int frameIndex;
        private BufferedImage currentFrame;

        public SplashPane() {
            try {
                background = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo\\2005-09-29-3957.jpeg"));
                frames = new ArrayList<>(40);
                List<BufferedImage> images = new ArrayList<>(20);
                for (int index = 0; index < 20; index++) {
                    try {
                        BufferedImage buffy = ImageIO.read(new File(index + ".png"));
                        images.add(createCompatibleImage(buffy));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                frames.addAll(images);
                Collections.reverse(images);
                frames.addAll(images);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            final Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (frameIndex >= frames.size()) {
                        frameIndex = 0;
                    }
                    currentFrame = frames.get(frameIndex);
                    frameIndex++;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(200, 200) : new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2d.drawImage(background, x, y, this);

                if (currentFrame != null) {

                    x = (getWidth() - currentFrame.getWidth()) / 2;
                    y = (getHeight() - currentFrame.getHeight()) / 2;
                    g2d.drawImage(currentFrame, x, y, this);

                }
                g2d.dispose();
            }
        }
    }

    public static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public static BufferedImage createCompatibleImage(BufferedImage master) {
        BufferedImage img = createCompatibleImage(master, master.getWidth(), master.getHeight());
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(master, 0, 0, null);
        g2d.dispose();
        return img;
    }

    public static BufferedImage createCompatibleImage(BufferedImage image,
            int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, image.getTransparency());
    }
}