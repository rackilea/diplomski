public void method1 (int x) {
if (x == 1) {
    try {
        Robot r = new Robot(); // R is defined in the try block. It is not visible outside of this block.
    } catch (AWTException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    r.mouseMove(50,50); // R is not defined anymore here