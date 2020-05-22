// Things that need to be set up only once.
final Robot robot = new Robot();
final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

// If you need a loop, start it here.
for (;;) {
    // Click at (x, y).
    robot.mouseMove(x, y);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(100);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(100);

    // Press Ctrl+C.
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_C);
    robot.delay(100);
    robot.keyRelease(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.delay(100);

    // Read clipboard.
    final String clipboardContents = (String) clipboard.getData(DataFlavor.stringFlavor);

    // Work with clipboard contents.
    System.out.println(clipboardContents);
}