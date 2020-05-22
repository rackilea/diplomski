import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class DrawOverLabel extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = 100;
   private static final Font TEXT_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 32);
   private static final int LABEL_COUNT = 40;

   public DrawOverLabel() {
      for (int i = 0; i < LABEL_COUNT; i++) {
         JLabel label = new JLabel("Label");
         label.setForeground(Color.green);
         label.setFont(label.getFont().deriveFont(Font.BOLD, 20));
         add(label);
      }
   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);

      g.setColor(Color.blue);
      g.setFont(TEXT_FONT);
      g.drawString("in paint", 20, 30);

//      super.paint(g);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.setColor(Color.red);
      g.setFont(TEXT_FONT);
      g.drawString("in paintComponent", 20, 60);

//      super.paintComponent(g);
   }

   @Override
   protected void paintChildren(Graphics g) {
      super.paintChildren(g);

      g.setColor(Color.gray);
      g.setFont(TEXT_FONT);
      g.drawString("in paintChildren", 20, 100);

//       super.paintChildren(g);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("DrawOverLabel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new DrawOverLabel());
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