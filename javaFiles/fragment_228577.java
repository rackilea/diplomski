import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class SimpleDrawMain extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private SimpleDrawPanel simpleDrawPanel = new SimpleDrawPanel(PREF_W, PREF_H);
   private MyMouse myMouse = new MyMouse();

   // drawStroke: thickness of lines drawn. Can change this as needed
   private Stroke drawStroke = new BasicStroke(6f);
   // drawColor -- change this as needed
   private Color drawColor = Color.BLUE; 

   public SimpleDrawMain() {
      simpleDrawPanel.addMouseListener(myMouse);
      simpleDrawPanel.addMouseMotionListener(myMouse);
      simpleDrawPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

      JPanel topPanel = new JPanel();
      topPanel.add(new JButton(new SaveImageAction("Save", KeyEvent.VK_S)));
      topPanel.add(new JButton(new ClearImageAction("Clear", KeyEvent.VK_C)));

      setLayout(new BorderLayout());
      add(topPanel, BorderLayout.PAGE_START);
      add(simpleDrawPanel, BorderLayout.CENTER);
   }

   private class MyMouse extends MouseAdapter {
      private Graphics2D g2;
      private Point point; // point to draw a line with

      @Override
      public void mousePressed(MouseEvent e) {
         if (e.getButton() != MouseEvent.BUTTON1) {
            return;
         }

         // get our Graphics object to draw with
         g2 = simpleDrawPanel.getMyImage().createGraphics();
         point = e.getPoint();  // get the first point
         g2.setStroke(drawStroke);  // set stroke and color
         g2.setColor(drawColor);
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         if (point == null) {
            return;
         }
         drawOnImage(e);
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         if (point == null) {
            return;
         }
         drawOnImage(e);

         // clean up things
         g2.dispose();
         g2 = null;
         point = null;
      }

      private void drawOnImage(MouseEvent e) {
         // better to draw a line between two points rather than an oval
         // get 2nd point, and then using 2 points, create line to draw
         Point p2 = e.getPoint();
         int x1 = point.x;
         int y1 = point.y;
         int x2 = p2.x;
         int y2 = p2.y;
         g2.drawLine(x1, y1, x2, y2);

         // reset the original point to the new point
         point = p2;

         simpleDrawPanel.repaint();
      }

   }

   private class SaveImageAction extends AbstractAction {
      public SaveImageAction(String name, int mnemonioc) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonioc);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         BufferedImage img = simpleDrawPanel.getMyImage();
         // TODO write code to save img to file         
      }
   }

   private class ClearImageAction extends AbstractAction {
      public ClearImageAction(String name, int mnemonioc) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonioc);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         simpleDrawPanel.clearImage();
      }
   }

   private static void createAndShowGui() {
      SimpleDrawMain mainPanel = new SimpleDrawMain();

      JFrame frame = new JFrame("SimpleDraw");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setResizable(false);
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

class SimpleDrawPanel extends JPanel {
   // preferred size dimensions for this JPanel
   private int prefW;
   private int prefH;
   // image to draw on
   private BufferedImage myImage;

   public SimpleDrawPanel(int prefW, int prefH) {
      this.prefW = prefW;
      this.prefH = prefH;
      myImage = new BufferedImage(prefW, prefH, BufferedImage.TYPE_INT_ARGB);
   }

   public BufferedImage getMyImage() {
      return myImage;            
   }

   public void clearImage() {
      // simply create a new BufferedImage
      myImage = new BufferedImage(prefW, prefH, BufferedImage.TYPE_INT_ARGB);
      repaint();
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(prefW, prefH);
   }

   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       if (myImage != null) {
           g.drawImage(myImage, 0, 0, null);
       }
   }

}