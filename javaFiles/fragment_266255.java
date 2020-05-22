package Code.simpleOutput;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;


public class GeoPattern {

     public static void main(final String[] args)
        throws InterruptedException // because it contains a sleep call
   {
     Finch myFinch = new Finch();

    for(int x = 4; x >0; x--) 
    {
      Thread.sleep(1000); // sleep a second
      myFinch.setWheelVelocities(255,255,1000);
      Thread.sleep(1000); // sleep another second
      myFinch.setWheelVelocities(255,0,800);
     }
     myFinch.quit();
     System.exit(0);
   }

}