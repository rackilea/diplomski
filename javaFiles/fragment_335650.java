import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class GuiDoubleDraw extends JPanel {
   private static final int BI_WIDTH = 500;
   private static final int BI_HEIGHT = BI_WIDTH;
   public static final Color PEN_COLOR = Color.black;
   private BufferedImage backgroundImg = new BufferedImage(BI_WIDTH, BI_HEIGHT,
         BufferedImage.TYPE_INT_ARGB);

   public GuiDoubleDraw() {
      MyMouseAdapter mouseAdapter = new MyMouseAdapter();
      addMouseListener(mouseAdapter);
      addMouseMotionListener(mouseAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (backgroundImg != null) {
         g.drawImage(backgroundImg, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(BI_WIDTH, BI_HEIGHT);
   }

   public BufferedImage getBackgroundImage() {
      BufferedImage copyImg = new BufferedImage(BI_WIDTH, BI_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);
      Graphics g = copyImg.getGraphics();
      g.drawImage(backgroundImg, 0, 0, null);
      g.dispose();
      return copyImg;
   }

   public void setBackgroundImage(BufferedImage bImg) {
      this.backgroundImg = bImg;
      repaint();
   }

   private class MyMouseAdapter extends MouseAdapter {
      Point previousPt = null;

      @Override
      public void mousePressed(MouseEvent mEvt) {
         previousPt = mEvt.getPoint();
      }

      @Override
      public void mouseDragged(MouseEvent mEvt) {
         drawPt(mEvt);
      }

      @Override
      public void mouseReleased(MouseEvent mEvt) {
         drawPt(mEvt);
      }

      private void drawPt(MouseEvent mEvt) {
         Graphics g = backgroundImg.getGraphics();
         Point nextPt = mEvt.getPoint();
         g.setColor(PEN_COLOR);
         g.drawLine(previousPt.x, previousPt.y, nextPt.x, nextPt.y);
         g.dispose();
         previousPt = nextPt;
         repaint();
      }

   }

   private static void createAndShowGui() {
      final GuiDoubleDraw guiDoubleDraw1 = new GuiDoubleDraw();
      final GuiDoubleDraw guiDoubleDraw2 = new GuiDoubleDraw();

      JFrame frame = new JFrame("Draw 1");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(guiDoubleDraw1);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      JDialog dialog = new JDialog(frame, "Draw 2", ModalityType.MODELESS);
      dialog.getContentPane().add(guiDoubleDraw2);
      dialog.pack();
      dialog.setLocationRelativeTo(null);
      dialog.setVisible(true);

      int timerDelay = 10 * 1000;
      new Timer(timerDelay, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            guiDoubleDraw1.setBackgroundImage(guiDoubleDraw2
                  .getBackgroundImage());
         }
      }).start();
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}