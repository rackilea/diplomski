public class SuperRobot extends Robot {
    public void typeKey(int keyCode) {
        keyPress(keyCode);
        delay(20);
        keyRelease(keyCode);
    }
}

public static void main(String[] args) {
    try {
        SuperRobot r = new SuperRobot();
        // Now, let's press Ctrl+A
        r.keyPress(KeyEvent.VK_CONTROL);
        r.typeKey(KeyEvent.VK_A);
        r.keyRelease(KeyEvent.VK_CONTROL);
    } catch (Exception ex) { // Either AWTException or SecurityException
        System.out.println("Oh no!");
    }
}