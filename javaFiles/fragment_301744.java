import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    BufferedImage png = ImageIO.read(...));
                    BufferedImage gif = ImageIO.read(...);
                    ImageIcon gifImg = new ImageIcon(...);

                    TestPane pngPane = new TestPane(png);
                    TestPane gifPane = new TestPane(gif);
                    TestPane imgPane = new TestPane(gifImg.getImage());

                    save(pngPane, "PNGTest.png");
                    save(gifPane, "gifTest.png");
                    save(imgPane, "imgGifTest.png");

                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void save(JPanel pane, String to) throws IOException {
        pane.setSize(pane.getPreferredSize());
        BufferedImage img = new BufferedImage(pane.getWidth(), pane.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        pane.printAll(g2d);
        g2d.dispose();

        ImageIO.write(img, "png", new File(to));
    }

    public class TestPane extends JPanel {

        private Image img;

        public TestPane(Image img) {
            this.img = img;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(img.getWidth(this), img.getHeight(this));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, 0, 0, this);
            g2d.dispose();
        }

    }

}