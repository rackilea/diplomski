import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.*;

public class ChangeVars extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final int DELAY = 20;
   public BufferedImage displayImage;
   private MyWorker myWorker;

   public ChangeVars() {
      try {
         myWorker = new MyWorker(DELAY);
         myWorker.execute();
      } catch (AWTException e) {
         e.printStackTrace();
      }
   }

   @Override
   // to initialize the panel to something
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (displayImage != null) {
         g.drawImage(displayImage, 0, 0, null);
      }
   }

   public void stopWorker() {
      if (myWorker != null && !myWorker.isDone()) {
         myWorker.setRunning(false);
         myWorker.cancel(true);
      }
   }

   private class MyWorker extends SwingWorker<Void, BufferedImage> {

      private volatile boolean running = true;
      private Robot robot;
      private int delay;

      public MyWorker(int delay) throws AWTException {
         this.delay = delay;
         robot = new Robot();
      }

      @Override
      protected Void doInBackground() throws Exception {
         while (running) {
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRect = new Rectangle(0, 0, d.width, d.height);
            BufferedImage img = robot.createScreenCapture(screenRect);
            publish(img);
            Thread.sleep(delay);
         }
         return null;
      }

      @Override
      protected void process(List<BufferedImage> chunks) {
         for (BufferedImage image : chunks) {
            Dimension sz = getSize();
            double scaleX = (double) sz.width / image.getWidth();
            double scaleY = (double) sz.height / image.getHeight();
            AffineTransform transform = AffineTransform.getScaleInstance(
                  scaleX, scaleY);
            AffineTransformOp transformOp = new AffineTransformOp(transform,
                  AffineTransformOp.TYPE_BILINEAR);
            displayImage = new BufferedImage(sz.width, sz.height,
                  BufferedImage.TYPE_INT_ARGB);
            displayImage = transformOp.filter(image, displayImage);
            repaint();
         }
      }

      public void setRunning(boolean running) {
         this.running = running;
      }

      public boolean getRunning() {
         return running;
      }

   }

   private static void createAndShowGui() {
      final ChangeVars changeVars = new ChangeVars();

      JFrame frame = new JFrame("ChangeVars");
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      frame.addWindowListener(new WindowAdapter() {

         @Override
         public void windowClosing(WindowEvent e) {
            if (changeVars != null) {
               changeVars.stopWorker();
            }
            System.exit(0);
         }

      });
      frame.getContentPane().add(changeVars);
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