import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Obicere
 */
public class LoadImageTest {

    public LoadImageTest() {
        final JFrame frame = new JFrame("Load Image Test");
        final MyPanel panel = new MyPanel(ImageScanner.loadImage());
        final ImageScanner scanner = new ImageScanner(panel);

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        new Thread(scanner).start();
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoadImageTest();
            }
        });
    }

    public static class ImageScanner implements Runnable {

        private static final File PATH_FILE = new File("image.txt");
        private final MyPanel instance;
        private long lastModified = PATH_FILE.lastModified();

        public ImageScanner(final MyPanel panel) {
            this.instance = panel;
        }

        @Override
        public void run() {
            while (true) {
                if (PATH_FILE.lastModified() != lastModified) {
                    System.out.println("Loading");
                    instance.setImage(loadImage());
                    lastModified = PATH_FILE.lastModified();
                }
                try {
                    Thread.sleep(50);
                } catch (final Exception ignored) {

                }
            }
        }

        public static Image loadImage() {
            try {
                final byte[] data = Files.readAllBytes(Paths.get(PATH_FILE.toURI()));
                final String path = new String(data);
                System.out.println(path);
                return ImageIO.read(new URL(path));
            } catch (final Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public class MyPanel extends JPanel {

        private Image render;

        public MyPanel(final Image render) {
            this.render = render;
        }

        @Override
        public void paintComponent(final Graphics g) {
            super.paintComponent(g);
            g.drawImage(render, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(render.getWidth(this), render.getHeight(this));
        }

        public void setImage(final Image image) {
            this.render = image;
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    repaint();
                    revalidate();
                }
            });
        }

    }
}