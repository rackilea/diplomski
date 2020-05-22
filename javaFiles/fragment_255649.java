import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PicStrip extends JPanel {
   public static final String[] IMAGE_URLS = {
         "http://upload.wikimedia.org/wikipedia/commons/6/63/Lagavulin_-_entrance.JPG",
         "http://upload.wikimedia.org/wikipedia/commons/1/1d/Parliament-Ottawa_edit1.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/b/b0/100OLYMP1.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/1/17/Arpino_panorama.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/a/ad/Cegonha_alsaciana.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/1/18/Eau_transparente_naturelle.JPG",
         "http://upload.wikimedia.org/wikipedia/commons/4/4d/FA-18F_Breaking_SoundBarrier.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/5/58/PuntadelEste.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/3/3c/Punta_Gorda_Belize-gm.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/6/64/Yungangshiku.JPG",
         "http://upload.wikimedia.org/wikipedia/commons/e/e2/Wheel_of_Konark%2C_Orissa%2C_India.JPG",
         "http://upload.wikimedia.org/wikipedia/commons/1/16/Muretto_a_secco.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/3/31/Mercedes_AMG_CLS_55_-_Demonstration_of_drifting_1a_1280x960.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/d/d3/Cascade_carieul_1280x960.jpg",
         "http://upload.wikimedia.org/wikipedia/commons/1/17/Bobbahn_ep.jpg"
         };

   private ImageIcon[] icons = new ImageIcon[IMAGE_URLS.length];
   private DefaultListModel iconListModel = new DefaultListModel();
   private JList iconList = new JList(iconListModel);
   private ImagePanel imagePanel = new ImagePanel();

   public PicStrip() {
      setLayout(new BorderLayout());
      add(new JScrollPane(iconList), BorderLayout.LINE_START);

      add(imagePanel, BorderLayout.CENTER);
      new SwingWorker<Void, ImageIcon>() {

         @Override
         protected Void doInBackground() throws Exception {
            for (String imageUrl : IMAGE_URLS) {
               BufferedImage img = ImageIO.read(new URL(imageUrl));
               img = ImageUtil.createScaledImage(img);
               ImageIcon icon = new ImageIcon(img, imageUrl);
               publish(icon);
            }
            return null;
         }

         protected void process(java.util.List<ImageIcon> chunks) {
            for (ImageIcon icon : chunks) {
               iconListModel.addElement(icon);
            }
         };

         protected void done() {
            Window win = SwingUtilities.getWindowAncestor(PicStrip.this);
            win.pack();
         };

      }.execute();

      iconList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      iconList.addListSelectionListener(new ListSelectionListener() {

         public void valueChanged(ListSelectionEvent e) {
            ImageIcon icon = (ImageIcon)iconList.getSelectedValue();
            final String imageUrl = icon.getDescription();
            new SwingWorker<BufferedImage, Void>() {
               protected BufferedImage doInBackground() throws Exception {
                  return ImageIO.read(new URL(imageUrl));
               };

               @Override
               protected void done() {
                  try {
                     imagePanel.setImage(get());
                  } catch (InterruptedException e) {
                     e.printStackTrace();
                  } catch (ExecutionException e) {
                     e.printStackTrace();
                  }
               }
            }.execute();
         }
      });
   }

   private static void createAndShowGui() {
      PicStrip mainPanel = new PicStrip();

      JFrame frame = new JFrame("PicStrip");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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

class ImagePanel extends JPanel {
   private static final int PREF_W = (3 * 1280) / 4;
   private static final int PREF_H = (3 * 960) / 4;
   private BufferedImage img = null;

   public void setImage(BufferedImage img) {
      this.img = img;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      if (img == null) {
         return;
      }
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(img, 0, 0, PREF_W, PREF_H, null);

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}

class ImageUtil {
   public static final int DEST_WIDTH = 100;
   public static final int DEST_HEIGHT = 75;
   public static final double ASPECT_RATIO = (double) DEST_WIDTH / DEST_HEIGHT;

   public static BufferedImage createScaledImage(BufferedImage original) {
      double origAspectRatio = (double) original.getWidth()
            / original.getHeight();
      double scale = origAspectRatio > ASPECT_RATIO ? 
            (double) DEST_WIDTH / original.getWidth() : 
               (double) DEST_HEIGHT / original.getHeight();            
      int newW = (int) (original.getWidth() * scale);            
      int newH = (int) (original.getHeight() * scale);
      BufferedImage img = new BufferedImage(DEST_WIDTH, DEST_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(original, 0, 0, newW, newH, null);
      g2.dispose();
      return img;
   }
}