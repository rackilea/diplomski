// Start Robot in a new thread.
new Thread(new Runnable() {
    @Override
    public void run() {
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
    }
}).start();

// Launch JFileChooser.
jFileChooser.getSelectedFile();