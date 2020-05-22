public class Test {
    public static void main(String[] args) {
        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_SHIFT);  
            robot.keyPress(KeyEvent.VK_SEMICOLON);  
            robot.keyRelease(KeyEvent.VK_SEMICOLON);  
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } catch (AWTException e) {
            // TODO Auto-generated catch bloc
            e.printStackTrace();
        }


    }
}