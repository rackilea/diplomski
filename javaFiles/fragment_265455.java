import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Scrollable;

public class Main {
   public static int[][] tiles;

   public static void main(String[] args) {
      Foo foo = new Foo();
      foo.run();
   }
}

class Foo {
   public void run() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      NumberPanel panel = new NumberPanel();

      // !! panel.setPreferredSize(new Dimension(512,448));
      JScrollPane scrollPane = new JScrollPane(panel);
      // !! scrollPane.getViewport().setPreferredSize(new Dimension(512, 448));

      scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      frame.add(scrollPane);
      frame.setVisible(true);
      frame.pack();

      Main.tiles = new int[32][32];

      while (true) {
         try {
            Thread.sleep(500);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         panel.repaint();
      }
   }

}

class NumberPanel extends JPanel implements Scrollable {

   private static final int PREF_W = 1200;
   private static final int PREF_H = 1200;
   private static final int VP_WIDTH = 512;
   private static final int VP_HEIGHT = 448;

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      paintScreen(g);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private void paintScreen(Graphics g) {
      int x = 0, y = 0;
      for (int i = 0; i < Main.tiles.length; i++) {
         for (int j = 0; j < Main.tiles[i].length; j++) {
            g.drawString(i + " " + j, x * 32, y * 32);
            y++;
         }
         y = 0;
         x++;
      }
   }

   @Override
   public Dimension getPreferredScrollableViewportSize() {
      return new Dimension(VP_WIDTH, VP_HEIGHT);
   }

   @Override
   public int getScrollableBlockIncrement(Rectangle arg0, int arg1, int arg2) {
      // TODO Consider improving
      return 0;
   }

   @Override
   public boolean getScrollableTracksViewportHeight() {
      return false;
   }

   @Override
   public boolean getScrollableTracksViewportWidth() {
      return false;
   }

   @Override
   public int getScrollableUnitIncrement(Rectangle arg0, int arg1, int arg2) {
      // TODO Consider improving
      return 0;
   }
}