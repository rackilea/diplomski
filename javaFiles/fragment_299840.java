public class TrafficLight implements Runnable {

   volatile boolean stop;

   // Irrelevant code

   public boolean isStop() {
     return stop;
   }
}