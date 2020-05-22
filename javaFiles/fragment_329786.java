public class ProblemClass extends JComponent {
    private static final int FRAME_FREQUENCY = 30;
    private final Timer animationTimer;

    //persistent reference to the image
    private BufferedImage bgImage;

    public ProblemClass() {
        this.animationTimer = new Timer(1000 / FRAME_FREQUENCY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Update the image on each call before repainting
                bgImage = GraphicsUtils.gaussianBlur(AnotherClass.getBgImage());
                repaint();
            }
        });
    }

    /** 
     * Start animation from another class
     */
    public void startAnimation() {
        this.animationTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g2) {
        g2.drawImage(bgImage, 0, 0, null);

        // Other code...
    }
}