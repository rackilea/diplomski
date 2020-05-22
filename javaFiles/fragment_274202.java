robot.keyPress(KeyEvent.VK_1);
try {
    Thread.sleep(50);
} catch(Exception e) {
    e.printStackTrace();
}
robot.keyRelease(KeyEvent.VK_1);