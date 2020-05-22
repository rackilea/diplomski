public class SimpleAnimationTest {

    private boolean running = true;
    private Rectangle box = new Rectangle(0, 90, 10, 10);
    private int dx = 4;
    protected static final int WIDTH = 200;
    protected static final int HEIGHT = 200;

    public static void main(String[] args) {
        new SimpleAnimationTest();
    }

    public SimpleAnimationTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();

                frame.setIgnoreRepaint(true);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.setSize(WIDTH, HEIGHT);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                frame.createBufferStrategy(2);
                final BufferStrategy bs = frame.getBufferStrategy();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long tock = 1000 / 60;
                        while (running) {

                            box.x += dx;
                            if (box.x + box.width > WIDTH) {
                                box.x = WIDTH - box.width;
                                dx *= -1;
                            } else if (box.x < 0) {
                                box.x = 0;
                                dx *= -1;
                            }

                            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                            g.setColor(Color.BLACK);
                            g.fillRect(0, 0, WIDTH, HEIGHT);
                            g.setColor(Color.WHITE);
                            g.fill(box);
                            g.dispose();
                            bs.show();
                            try {
                                Thread.sleep(tock);
                            } catch (InterruptedException ex) {
                            }
                        }
                        bs.dispose();

                    }
                }).start();

            }
        });
    }
}