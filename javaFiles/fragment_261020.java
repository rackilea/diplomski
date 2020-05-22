public class TestApp extends JFrame {
    public static void main(String[] args) {
        TestApp frame = new TestApp();
        Container c = frame.getContentPane();
        // do something with c
        frame.pack();
        frame.show();
    }

    /* constructor */
    public TestApp() {
        Container c = getContentPane(); // same as this.getContentPane()
        // initialize contents of frame
    }
}