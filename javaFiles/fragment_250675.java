import java.awt.Dimension;
import javax.swing.*;

@SuppressWarnings("serial")
public class MathmePanel  extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 500;

   public MathmePanel() {
      // create my GUI here
   }

   // set size in a flexible and safe way
   @Override
   public Dimension getPreferredSize() {
      Dimension superSize = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSize;
      }
      int prefW = Math.max(PREF_W, superSize.width);
      int prefH = Math.max(PREF_H, superSize.height);
      return new Dimension(prefW, prefH);
   }

   private static void createAndShowGui() {
      MathmePanel mainPanel = new MathmePanel();

      // create JFrame rather than override it
      JFrame frame = new JFrame("Pruebax1");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      // Start Swing GUI in a safe way on the Swing event thread
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}