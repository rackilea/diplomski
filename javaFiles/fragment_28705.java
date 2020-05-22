import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MyWindow {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final Color COLOR0 = Color.red;
   private static final Color COLOR1 = Color.blue;
   private static final float COLOR_REPEAT_DIST = 30f;
   private JLabel backGroundLabel = new JLabel();

   public MyWindow() {
      backGroundLabel.setOpaque(true);
      backGroundLabel.setLayout(new BorderLayout());
      int eb = 15;
      BufferedImage bkgrndImg = createBkgrndImage();
      ImageIcon icon = new ImageIcon(bkgrndImg);
      backGroundLabel.setIcon(icon);

      JPanel bottomPanel = new JPanel();
      bottomPanel.setLayout(new FlowLayout(SwingConstants.RIGHT, eb, eb));
      bottomPanel.setOpaque(false);
      bottomPanel.add(new JButton("Plot"));
      backGroundLabel.add(bottomPanel, BorderLayout.PAGE_END);
   }

   private BufferedImage createBkgrndImage() {
      BufferedImage img = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setPaint(new GradientPaint(0f, 0f, COLOR0, COLOR_REPEAT_DIST, COLOR_REPEAT_DIST, COLOR1, true));
      g2.fillRect(0, 0, PREF_W, PREF_H);
      g2.dispose();
      return img;
   }

   public JComponent getMainPane() {
      return backGroundLabel;
   }

   private static void createAndShowGui() {
      MyWindow mainPanel = new MyWindow();

      JFrame frame = new JFrame("MyWindow");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel.getMainPane());
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