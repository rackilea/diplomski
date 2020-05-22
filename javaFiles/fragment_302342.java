import edu.cmu.ri.createlab.terk.robot.finch.Finch;

 public class FinchVIVA {


public static void main(String[] args){
    Finch myf = new Finch();
    int light = 120; //light intensity
    long startInterval = System.currentTimeMillis(); //sets the current time 
    int forward,right, left;
    forward=right=left=0;
    String previousCommand="";
    while (true) {
        if (!myf.isObstacle() && myf.getRightLightSensor() > light && myf.getLeftLightSensor() > light) { //if no obstacle and both sensors get enough light
            ledAndWheels(myf, 152, 148); //Finch will go forward (the number values are speeds for each wheel)
            startInterval = System.currentTimeMillis();               
            if(!previousCommand.equals("forward"))
            {
                  System.out.println("forward");
            } 
             previousCommand="forward";
            forward++;
        } else if (!myf.isObstacle() && myf.getRightLightSensor() > light && myf.getLeftLightSensor() < light) { //if no obstacle and light sensors right > left
            ledAndWheels(myf, 150, -100); //Finch will turn right
            startInterval = System.currentTimeMillis();
            if(!previousCommand.equals("right"))
            {
                  System.out.println("right");
            } 
             previousCommand="right";
            right++;
        } else if (!myf.isObstacle() && myf.getRightLightSensor() < light && myf.getLeftLightSensor() > light) { //if no obstacle and light sensors right < left
            ledAndWheels(myf, -100, 1);//Finch will turn right
            startInterval = System.currentTimeMillis();
             if(!previousCommand.equals("left"))
            {
                  System.out.println("left");
            } 
             previousCommand="left";
             left++;
        } else {
            myf.stopWheels();//this will stio the wheels
            if ((myf.isObstacle()) || (myf.getRightLightSensor() < light && myf.getLeftLightSensor() < light)) {
                setLed(myf, 255, 0, 0);
            }
            if ((System.currentTimeMillis() - startInterval) > 5000) {
                myf.quit();
                break;
            }


        }
    }

          // If condition to check which of the counter variables(forward, right, left) are greater 
         // Then print which of them was greatest to get your expected result.. 
}

public static void setLed(Finch myf, int r, int g, int b) {
    myf.setLED(r, g, b);
}

public static void ledAndWheels(Finch myf, int leftWheel, int rightWheel) {
    setLed(myf, 0, 0, 255);
    myf.setWheelVelocities(leftWheel, rightWheel);
    myf.buzz(1500,60);

}
}