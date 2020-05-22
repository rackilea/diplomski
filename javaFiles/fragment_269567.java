import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowBackgroundImage {
   public static final String IMAGE_PATH = "https://duke.kenai.com/glassfish/GlassFishMedium.jpg";

   private static void createAndShowUI() {
      Image image = null;
      try {
         URL url = new URL(IMAGE_PATH);
         image = ImageIO.read(url);
         // JLabel label = new JLabel(new ImageIcon(image));
         ImagePanelA imagePanel = new ImagePanelA(image);

         JFrame frame = new JFrame("Big Duke Image");
         frame.getContentPane().add(imagePanel);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

@SuppressWarnings("serial")
class ImagePanelA extends JPanel {
   private Image image;

   public ImagePanelA(Image image) {
      this.image = image;
      setLayout(new GridBagLayout());

      add(new JButton("Monday"), createGbc(0, 0, 1, 1));
      add(new JButton("Tuesday"), createGbc(1, 0, 1, 1));
      add(new JButton("Wednesday"), createGbc(0, 1, 1, 1));
      add(new JButton("Thursday"), createGbc(1, 1, 1, 1));
   }

   private GridBagConstraints createGbc(int x, int y, int w, int h) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = w;
      gbc.gridheight = h;

      gbc.weightx = 0.0; // bunches stuff in center in x orientation
      gbc.weighty = 0.0; // bunches stuff in center in y orientation
      gbc.fill = GridBagConstraints.BOTH;
      gbc.insets = new Insets(5, 5, 5, 5);

      return gbc;
   }

   @Override
   public Dimension getPreferredSize() {
      Dimension superSize = super.getPreferredSize();
      if (isPreferredSizeSet() || image == null) {
         return superSize;
      }
      int prefW = Math.max(image.getWidth(null), superSize.width);
      int prefH = Math.max(image.getHeight(null), superSize.height);
      return new Dimension(prefW, prefH);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (image != null) {
         g.drawImage(image, 0, 0, null);
      }
   }
}