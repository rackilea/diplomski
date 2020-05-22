import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventSource {
   JFrame frame = new JFrame();

   public static void main(String[] args) {
      new MouseEventSource().start();
   }

   public void start() {
      JPanel p1 = createPanel("Panel 1", Color.BLUE);
      JPanel p2 = createPanel("Panel 2", Color.RED);
      MyMouseListener ml = new MyMouseListener();
      p1.addMouseListener(ml);
      p2.addMouseListener(ml);
      frame.setLayout(new FlowLayout());
      frame.add(p1);
      frame.add(p2);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   public JPanel createPanel(String name, Color color) {
      JPanel panel = new JPanel() {
         public String toString() {
            return name;
         }
      };
      panel.setBackground(color);
      panel.setPreferredSize(new Dimension(250, 250));
      return panel;
   }

   private class MyMouseListener extends MouseAdapter {
      public void mouseClicked(MouseEvent e) {
         // not really necessary to print toString()
         JPanel panel = (JPanel) e.getSource();
         System.out.println(panel);
      }
   }
}