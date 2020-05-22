import javax.swing.JFrame;

public class MyStandAlone {
   private static void createAndShowUI() {
      MyPanel myPanel = new MyPanel();
      JFrame frame = new JFrame("MyPanel");
      frame.getContentPane().add(myPanel);
      frame.setJMenuBar(myPanel.methodThatReturnsJMenuBar());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}