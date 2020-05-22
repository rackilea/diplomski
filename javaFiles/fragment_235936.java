public void send(String s) {
    if (null == s) return;
    Robot r = null;
    char[] chars = s.toCharArray();
    try {
        for (char c : chars) {
                int code = c;
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(code);
                r = new Robot();
                r.delay(40);
                r.keyPress(keyCode);
                r.keyRelease(keyCode);
        } 
    } catch (AWTException ex) {
        System.err.println(ex.getMessage());
    }
}