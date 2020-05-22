import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class AnimateImages extends JPanel {
    private static final int IMAGE_ROWS = 10;
    private static final int IMAGE_COLS = 10;
    private static final int IMAGE_SIZE = 50;
    private static final int DIM_WIDTH = IMAGE_COLS * IMAGE_SIZE;

    private final List<MyImage> images;
    private Image image;
    private int currX = -IMAGE_SIZE;
    private int currY;

    public AnimateImages() {
        try {
            image = ImageIO.read(new URL("http://swoo.co.uk/content/images/icons/stackoverflow.png"));
        } catch (IOException ex) {
            Logger.getLogger(AnimateImages.class.getName()).log(Level.SEVERE, null, ex);
        }
        images = createImages();

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MyImage image : images) {
                    if (!image.isDraw()) {
                        image.setDraw(true);
                        break;
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }

    private List<MyImage> createImages() {
        List<MyImage> list = new ArrayList<>();
        for (int i = 0; i < IMAGE_ROWS * IMAGE_COLS; i++) {
            if (currX >= DIM_WIDTH) {
                currX = 0;
                currY += IMAGE_SIZE;
            } else {
                currX += IMAGE_SIZE;
            }
            list.add(new MyImage(image, currX, currY));

        }
        return list;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MyImage img : images) {
            img.draw(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(IMAGE_SIZE * IMAGE_COLS, IMAGE_SIZE * IMAGE_ROWS);        
    }

    public class MyImage {

        Image image;
        int x, y;
        boolean draw = false;

        public MyImage(Image image, int x, int y) {
            this.image = image;
            this.x = x;
            this.y = y;
        }

        public void setDraw(boolean draw) {
            this.draw = draw;
        }

        public boolean isDraw() {
            return draw;
        }

        public void draw(Graphics g) {
            if (draw) {
                g.drawImage(image, x, y, IMAGE_SIZE, IMAGE_SIZE, AnimateImages.this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new AnimateImages());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}