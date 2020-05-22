import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
   private static final Dimension PREF_SIZE = new Dimension(400, 300);

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString("hi", 50, 50);
   }

   @Override
   public Dimension getPreferredSize() {
      return PREF_SIZE;
   }

   public JMenuBar methodThatReturnsJMenuBar() {
      JMenu menu = new JMenu("Menu");
      JMenuBar menuBar = new JMenuBar();
      menuBar.add(menu);
      return menuBar;
   }
}