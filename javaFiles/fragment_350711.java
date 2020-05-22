public class RobotLib {

private static Robot robot;

public RobotLib(){
  try {
    robot = new Robot();
} catch (AWTException e) {
    e.printStackTrace();
}
}

// Press Function
public void Press(int key, int time){ 
    robot.keyPress(key);
    robot.delay(time);
    robot.keyRelease(key);
} 

}