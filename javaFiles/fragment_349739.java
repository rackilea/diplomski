import java.awt.Graphics;
import java.awt.Image;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class MyBoardPannel extends JPanel {
   protected static final String SAMPLE_IMAGE = "sampleImage";
   Image imageToShow = null;

   public MyBoardPannel() {
      SwingWorker<Image, Void> mySW = new SwingWorker<Image, Void>() {

         @Override
         protected Image doInBackground() throws Exception {
            return loadImage(SAMPLE_IMAGE);
         }

         @Override
         protected void done() {
            try {
               imageToShow = get();
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
      };

      mySW.execute();
   }

   @Override
   public void paintComponent(Graphics grahics) {
      super.paintComponent(grahics);
      if (imageToShow != null) {
         grahics.drawImage(imageToShow, 0, 0, null);
      }
   }

   private Image loadImage(String imageName) {
      InputStream imageStream = getClass().getResourceAsStream(
            "/" + imageName + ".png");
      try {
         return ImageIO.read(imageStream);
      } catch (Exception e) {
         final String errorMessage = "Failed to load image " + imageName;
         System.err.println(errorMessage);
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               JOptionPane.showMessageDialog(MyBoardPannel.this, errorMessage,
                     "Image loading error", JOptionPane.ERROR_MESSAGE);
               System.exit(1);
            }
         });
      }

      return null;
   }

}