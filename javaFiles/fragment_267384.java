import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo extends TimerTask {

   private long time = System.currentTimeMillis();

   @Override public void run() {
      long elapsed = System.currentTimeMillis() - time;
      System.err.println( elapsed );
      time = System.currentTimeMillis();
   }

   public static void main( String[] args ) throws Exception {
      Timer t = new Timer( "My 100 ms Timer", true );
      t.schedule( new TimerDemo(), 0, 100 );
      Thread.sleep( 1000 );              // wait 1 seconde before terminating
   }
}