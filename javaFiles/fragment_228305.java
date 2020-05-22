import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageButton extends JPanel {
   private static final int IMG_WIDTH = 50;
   private static final Color SHAPE_COLOR = Color.RED;
   private static final int GAP = 4;
   private JButton circleButton = new JButton();
   private JButton squareButton = new JButton();

   public ImageButton() {
      BufferedImage circleImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = circleImg.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(SHAPE_COLOR);
      int x = GAP;
      int y = x;
      int width = IMG_WIDTH - 2 * x;
      int height = IMG_WIDTH - 2 * y;
      g2.fillOval(x, y, width, height);
      g2.dispose();
      circleButton.setIcon(new ImageIcon(circleImg));

      BufferedImage squareImg = new BufferedImage(IMG_WIDTH, IMG_WIDTH, BufferedImage.TYPE_INT_ARGB);
      g2 = squareImg.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(SHAPE_COLOR);
      g2.fillRect(x, y, width, height);
      g2.dispose();
      squareButton.setIcon(new ImageIcon(squareImg));

      add(circleButton);
      add(squareButton);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ImageButton");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ImageButton());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}