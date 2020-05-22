public class Gater {

    public void moveToGate(){
        Robot robot = new Robot ();
        Thread.sleep(2000);
        robot.mouseMove(262,105);
        Thread.sleep(500);
        robot.mousePress( InputEvent.BUTTON1_MASK );
        robot.mouseRelease( InputEvent.BUTTON1_MASK );
        Thread.sleep(5000);
    }

}