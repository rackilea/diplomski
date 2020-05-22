import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ShowMyImage {

    public static void main(String[] args) {
        new ShowMyImage();
    }

    public ShowMyImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                ImagePane pane = new ImagePane();
                try {
                    pane.setImg(ImageIO.read(new File("C:\\hold\\thumbnails\\_MTCGAC__Pulling_Cords_by_Dispozition.png")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(pane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImagePane extends JPanel {

        private BufferedImage img;

        public ImagePane() {
        }

        public void setImg(BufferedImage value) {
            if (img != value) {
                img = value;
                repaint();
            }
        }

        public BufferedImage getImg() {
            return img;
        }

        @Override
        public Dimension getPreferredSize() {
            BufferedImage img = getImg();
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            BufferedImage img = getImg();
            if (img != null) {
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight()- img.getHeight()) / 2;

                g2d.drawImage(img, x, y, this);
            }
            g2d.dispose();
        }
    }
}