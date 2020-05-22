import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyBetterCanvas extends JComponent {

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawOval(10, 10, 200, 200);
   }


   public static void main(String[] a) {
      MyBetterCanvas canvas = new MyBetterCanvas();
      canvas.setPreferredSize(new Dimension(300, 300));
      JFrame window = new JFrame("My Better Canvas");
      window.getContentPane().add(canvas);      
      window.setLocationByPlatform(true);
      window.pack();
      window.setVisible(true);
   }
}