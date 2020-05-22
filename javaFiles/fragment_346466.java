import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

public class SquareGridTest extends JPanel {
   public static final Color[] COLORS = { Color.blue, Color.red, Color.yellow,
         Color.orange, Color.green, Color.cyan, Color.lightGray, Color.magenta,
         Color.white, Color.black };
   private static final Icon[] ICONS = new Icon[COLORS.length];
   private static final int ROWS = 20;
   private static final int COLS = 30;
   private static final int BI_WIDTH = 20;
   private static final int BI_HEIGHT = BI_WIDTH;
   private static final int TIMER_DELAY = 15;
   protected static final int NUMBER_TO_SWAP = 15;
   private JLabel[][] grid = new JLabel[ROWS][COLS];
   private Random random = new Random();

   static {
      for (int i = 0; i < ICONS.length; i++) {
         BufferedImage img = new BufferedImage(BI_WIDTH, BI_HEIGHT, BufferedImage.TYPE_INT_ARGB);
         Graphics g = img.getGraphics();
         g.setColor(COLORS[i]);
         g.fillRect(0, 0, BI_WIDTH, BI_HEIGHT);
         g.dispose();
         ICONS[i] = new ImageIcon(img);
      }
   }

   public SquareGridTest() {
      setLayout(new GridLayout(ROWS, COLS));
      for (int row = 0; row < grid.length; row++) {
         for (int col = 0; col < grid[row].length; col++) {
            JLabel label = new JLabel();
            int index = random.nextInt(COLORS.length);
            label.setIcon(ICONS[index]);
            add(label);
            grid[row][col] = label;            
         }
      }

      new Timer(TIMER_DELAY, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            for (int i = 0; i < NUMBER_TO_SWAP; i++) {
               int row = random.nextInt(ROWS);
               int col = random.nextInt(COLS);
               int iconIndex = random.nextInt(ICONS.length);
               grid[row][col].setIcon(ICONS[iconIndex]);
            }
         }
      }).start();
   }

   private static void createAndShowGui() {
      SquareGridTest mainPanel = new SquareGridTest();

      JFrame frame = new JFrame("SquareGridTest");
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