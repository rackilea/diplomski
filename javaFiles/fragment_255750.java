import javax.swing.*;

public class LifeCycleFrame {

   private static void createAndShowGui() {
      LifeCycle2 lifeCycle2 = new LifeCycle2();

      JFrame frame = new JFrame("LifeCycleTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(lifeCycle2.getMainPanel());
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