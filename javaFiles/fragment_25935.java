private void writeString(String s) {
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isUpperCase(c)) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }
        robot.keyPress(Character.toUpperCase(c));
        robot.keyRelease(Character.toUpperCase(c));

        if (Character.isUpperCase(c)) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
    robot.delay(delay);
}