JFrame frame = new JFrame("Test");
frame.setAlwaysOnTop(true);
frame.setUndecorated(true);
try {
    Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
    if (awtUtilsClass != null) {

        Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
        method.invoke(null, frame, false);
    }

} catch (Exception exp) {
}
//frame.setBackground(new Color(0, 0, 0, 0));
frame.setContentPane(circlePane);