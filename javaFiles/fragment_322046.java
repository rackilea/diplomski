public void openExtension() {
    robotKeyPress(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
    robotKeyRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_Y);
}

private void robotKeyPress(int... keys) {
    for (int k : keys) {
        robot.keyPress(k);
    }
}

private void robotKeyRelease(int... keys) {
    for (int k : keys) {
        robot.keyRelease(k);
    }
}