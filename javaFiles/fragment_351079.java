private void pressKey() {

    try {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_WINDOWS)
        r.keyPress(KeyEvent.VK_UP); //Windows button is still pressed at this moment
        r.keyRelease(KeyEvent.VK_UP);
        r.keyRelease(KeyEvent.VK_WINDOWS);          
    } catch (Exception e) {
        e.printStackTrace();
    }
}