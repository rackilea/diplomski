import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ImageAnimator {

    public ImageAnimator() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AnimationPane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static class Drawable {

        private int x;
        private final int y;
        private static final Image image = image();

        //construct with a random y value
        public Drawable(int x) {
            this(x, -1);
        }

        public Drawable(int x, int y) {
            this.x = x;
            this.y =  y < 0 ? (int) (Math.random() * (512 - 20)) : y;
        }

        public int getX() { return x;  }

        public int getY() { return y; }

        public void update() {  x--; }

        public Image getImage(){  return image; }

        public static Image image() {

            URL url = null;
            try {
                url = new URL("https://dl1.cbsistatic.com/i/r/2017/09/24/b2320b25-27f3-4059-938c-9ee4d4e5cadf/thumbnail/32x32/707de8365496c85e90c975cec8278ff5/iconimg241979.png");
                return ImageIO.read(url);

            } catch ( IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }

    public class AnimationPane extends JPanel {

        private final List<Drawable> drawables;
        private static final int W = 288, H = 512, CYCLE_TIME = 5;

        public AnimationPane() {
            drawables = new ArrayList<>(2);
            drawables.add(new Drawable(W, H/4));
            drawables.add(new Drawable(W, 3*H/4));

            Timer timer = new Timer(CYCLE_TIME, e ->  animate());
            timer.start();
        }

        private void animate() {

          for (Drawable drawable : new ArrayList<>(drawables)) {

              drawable.update();
              if(drawable.getX() == W/2) {
                  drawables.add(new Drawable(W)); //random Y
              }
              if(drawable.getX() <= 0) {
                  drawables.remove(drawable);
              }
          }
          repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(W, H);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Drawable drawable : drawables ) {
                g.drawImage(drawable.getImage(),drawable.getX(), drawable.getY(), null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new ImageAnimator());
    }
}