public class Slider {

  public static void main(String[] args) {
    Thread thread = new Thread() {
        @Override
        public void run() {
            /*
             * If you are going to use something like this, beware you are multi-threading
             * Make sure what you do is thread-safe
             */
            moveLeft(32, 500);
        }
    };
    thread.start();
  }

  public static void moveLeft(int distance, int milis) {
    //time_px is how many nanoseconds the Thread can sleep until it has to move 1 dx
    double time_px = (100000*milis)/distance;
    if (time_px >= 1) {
        //Get the milis and nanos, rounding for Thread.sleep
        long time_round = (long) Math.floor(time_px);
        long milis_sleep = time_round/100000;
        System.out.print("Waiting " + milis_sleep + "ms ");
        int nano_sleep = (int) (time_round%100000); 
        System.out.println(nano_sleep + "ns per dx");
        for (int i=0; i<distance; i++) {
            try {
                Thread.sleep(milis_sleep, nano_sleep);
                /*
                 * Your code here
                 * A long code here might not get you the desired result since the sleeping does
                 * not account for the time spent processing the code. But this is a good start
                 */
                System.out.println("moving 1 dx");
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    else {
        System.out.println("Cannot go that fast");
        //If you are moving that fast (more than 1 dx per nanosecond) then you need to change this up a little.
    }
  }
}