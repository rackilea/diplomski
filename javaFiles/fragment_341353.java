public class ScanFrameApplet extends JApplet {
  try {
    java.awt.EventQueue.invokeAndWait(new Runnable() {
    @Override
    public void run() {
        initComponents();
        ScanFrame scanFrame = new ScanFrame(ScanFrameApplet.this);