import java.lang.reflect.InvocationTargetException;
import javax.swing.*;

public class MyApplet extends JApplet {
   @Override
   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               getContentPane().add(new MyJPanel());             
            }
         });
      } catch (InterruptedException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
   }
}