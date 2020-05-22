import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ExpandingImage extends JPanel {
   public static final String GUITAR = "http://duke.kenai.com/Oracle/OracleStrat.png";
   BufferedImage img;

   public ExpandingImage(String imgUrlPath) throws IOException {
      URL imgUrl = new URL(imgUrlPath);
      img = ImageIO.read(imgUrl);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
      }
   }


   private static void createAndShowGui() {
      ExpandingImage mainPanel;
      try {
         mainPanel = new ExpandingImage(GUITAR);
         JFrame frame = new JFrame("ExpandingImage");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(mainPanel);
         frame.pack();
         frame.setLocationByPlatform(true);
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
         frame.setVisible(true);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}