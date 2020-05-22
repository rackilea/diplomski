private FrameTest frame = this;

public  void mainScreen() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
                frame.setVisible(true);
        }
    });
}