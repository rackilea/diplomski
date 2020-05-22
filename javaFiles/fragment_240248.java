class FrameTwo extends JFrame {
    private FramOne firstFrame;

    public FrameTwo(FrameOne firstFrame) {
        this.firstFrame = firstFrame;
    };

    public void doSomething() {
        System.out.println(this.firstFrame.someMethod());
    };
};