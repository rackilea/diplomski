public class JFrame2 extends JFrame {
    public JFrame2(JFrame3 frame) {
        this.frame = frame;
        // Now you add your listeners, you have access to the sliders of your JFrame3
        ...
    }
    private JFrame3 frame;
    ...
}