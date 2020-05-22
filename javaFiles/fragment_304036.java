public static void main(String[] args) throws AWTException {
    String osName = System.getProperty("os.name");        
    boolean isOSX = osName.startsWith("Mac OS X");
    boolean isWin = osName.startsWith("Windows");

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection str = new StringSelection("Héllõ Wörld");
    clipboard.setContents(str, str);
    Robot robot = new Robot();

    if (isMac) {
        // ⌘-V on Mac
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);        
    } else if (isWin) {
        // Ctrl-V on Win
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    } else {
        throw new AssertionError("Not tested on "+osName);
    }
}