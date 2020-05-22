import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingTestFrame2 {
   private static void createAndShowGui() {
      JFrame frame = new JFrame("DrawingTestFrame2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      DrawingTest2 drawingTest = new DrawingTest2();

      frame.getContentPane().add(drawingTest);
      frame.setJMenuBar(drawingTest.createMenuBar());
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

class DrawingTest2 extends JPanel {

   private static final int PREF_W = 500;
   private static final int PREF_H = 300;
   private static final int RECT_W = 100;
   private static final int RECT_H = 20;
   public static final Rectangle BOTTOM_RECT = new Rectangle(PREF_W/2 - RECT_W/2, PREF_H - RECT_H, 
         RECT_W, RECT_H);
   private String[] menuItemStrings = {"One", "Two", "Three"};
   public Point mouseLocation;
   private BufferedImage bufferedImage = new BufferedImage(PREF_W, PREF_H, 
         BufferedImage.TYPE_INT_ARGB);
   private JLabel mousePositionLabel = new JLabel("", SwingConstants.RIGHT);

   public DrawingTest2() {
      MouseAdapter mouseAdapter = new MyMouseAdapter();
      addMouseListener(mouseAdapter);
      addMouseMotionListener(mouseAdapter);

      mousePositionLabel.setForeground(Color.gray);
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.anchor = GridBagConstraints.SOUTHEAST;
      add(mousePositionLabel, gbc);

      Graphics2D g2 = bufferedImage.createGraphics();
      g2.setPaint(new GradientPaint(0, 0, Color.yellow, 40, 40, Color.green, true));
      g2.fillRect(0, 0, PREF_W, PREF_H);
      g2.dispose();
      g2 = bufferedImage.createGraphics();
      g2.setColor(Color.red);
      g2.setStroke(new BasicStroke(3f));
      g2.drawRect(10, 10, 110, 110);
      g2.dispose();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (bufferedImage != null) {
         g.drawImage(bufferedImage, 0, 0, this);
      }
      if (mouseLocation != null) {
         g.drawString("X: " + mouseLocation.getX() + "  Y: "
               + mouseLocation.getY(), this.getWidth() / 2 - 50,
               this.getHeight() - 10);
      }
   }

   public JMenuBar createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu menu = new JMenu("Menu");
      for (int i = 0; i < menuItemStrings .length; i++) {
         menu.add(new JMenuItem(menuItemStrings[i]));
      }
      menuBar.add(menu );
      return menuBar;
   }

   class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mouseMoved(MouseEvent mEvt) {
         mouseLocation = mEvt.getLocationOnScreen();
         repaint(BOTTOM_RECT);

         String mousePosStr = String.format("x:%d y:%d", mouseLocation.x, mouseLocation.y);
         mousePositionLabel.setText(mousePosStr);
      }
   }
}