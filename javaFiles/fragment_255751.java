import java.lang.reflect.InvocationTargetException;    
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class LifeCycleApplet extends JApplet {
   @Override
   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               LifeCycle2 lifeCycle2 = new LifeCycle2();
               getContentPane().add(lifeCycle2.getMainPanel());
            }
         });
      } catch (InvocationTargetException | InterruptedException e) {
         e.printStackTrace();
      }
   }
}