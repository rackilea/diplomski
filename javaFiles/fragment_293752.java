import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel {
   public static final Color DARK_COLOR = Color.red.darker().darker().darker();
   public static final Color LIGHT_COLOR = Color.lightGray.brighter();
   public static final int SQUARE_SIDE = 60;
   private static final int ROW_COUNT = 8;

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(ROW_COUNT * SQUARE_SIDE, ROW_COUNT * SQUARE_SIDE);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int i = 0; i < ROW_COUNT; i++) {
         for (int j = 0; j < ROW_COUNT; j++) {
            Color c = (i % 2 == j % 2) ? LIGHT_COLOR : DARK_COLOR;
            g.setColor(c);
            int x = i * SQUARE_SIDE;
            int y = j * SQUARE_SIDE;
            g.fillRect(x, y, SQUARE_SIDE, SQUARE_SIDE);
         }
      }
   }

   public Grid() {
      // TODO Auto-generated constructor stub
   }

   private static void createAndShowGui() {
      Grid mainPanel = new Grid();

      JFrame frame = new JFrame("Grid");
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