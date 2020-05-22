import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
   public static void main(String[] args) {
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {

         @Override
         public void run() {
           System.out.println("here");
           try {
              Thread.sleep(10 * 1000);
           } catch (InterruptedException e) {}
         }
      }, 1000, 1000);
   }
}