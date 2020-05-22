import javax.swing.JApplet;

public class MyApplet extends JApplet {
   public void init() {
      try {
         javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               createGUI();
            }
         });
      } catch (Exception e) {
         System.err.println("createGUI didn't successfully complete");
      }
   }

   private void createGUI() {
      getContentPane().add(new MyPanel());
   }
}