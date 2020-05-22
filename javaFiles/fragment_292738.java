public void method1 (int x) {
if (x == 1) {
    try {
        Robot r = new Robot();
        r.mouseMove(50,50);
    } catch (AWTException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }