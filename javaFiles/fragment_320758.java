import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class TestImagePanel extends JPanel {
   private static final int BI_WIDTH = 640;
   BufferedImage currentView = new BufferedImage(BI_WIDTH, BI_WIDTH, BufferedImage.TYPE_INT_ARGB);

   public TestImagePanel() {
      Graphics g = currentView.getGraphics();
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g.setColor(Color.black);
      g.setFont(new Font("Arial", Font.BOLD, 60));
      g.drawString("No Map Yet Open", 20, currentView.getHeight()/2);
      g.dispose();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (currentView != null) {
         g.drawImage(currentView, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (currentView != null) {
         return new Dimension(BI_WIDTH, BI_WIDTH);
      }
      return super.getPreferredSize();
   }

   private static void createAndShowGui() {
      TestImagePanel mainPanel = new TestImagePanel();

      JFrame frame = new JFrame("TestImagePanel");
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