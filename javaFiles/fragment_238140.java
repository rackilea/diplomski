import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyApp extends JPanel {

   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private static final int DELAY = 17;
   private int count = 0;

   public MyApp() {
      new Timer(DELAY, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            count++;
            repaint();
         }
      }).start();
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString("Count = " + count, 20, 20);
   }

   private static void createAndShowGUI() {
      MyApp paintEg = new MyApp();

      JFrame frame = new JFrame("MyApp");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(paintEg);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}