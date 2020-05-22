public class Road implements Runnable {

   private TrafficLight trafficLight;

   public Road (TrafficLight trafficLight) {
     this.trafficLight = trafficLight;     
   }

   @Override
   public void run() {
     // Irrelevant code
     if(trafficLight.isStop()) {
       // do something
     } 
   }
}