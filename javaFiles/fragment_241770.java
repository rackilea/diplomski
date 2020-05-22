public class ThingUpdatingRunnable implements Runnable {
     private final Thing thing;

     public ThingUpdatingRunnable(Thing thing) {
        this.thing = thing;
     }

     @Override
     public void run() {
          thing.update();
     }
}