public class TestPane extends JPanel {

    private Random random = new Random();

    private List<Rectangle> rectangles = new ArrayList<>(25);

    public TestPane() {
        for (int i = 0; i < 1000; i++) {
            Rectangle rectangle = new Rectangle(Color.CYAN,
                            Color.BLACK,
                            random.nextInt(10),
                            random.nextInt(200),
                            random.nextInt(200),
                            random.nextInt(200), random.nextInt(200));
            rectangle.set_fill_transparency(random.nextInt(255));
            rectangle.set_rotate_angle(random.nextInt(180));
            rectangles.add(rectangle);
        }
        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Rectangle rectangle : rectangles) {
                    rectangle.set_height(random.nextInt(200));
                    rectangle.set_width(random.nextInt(200));
                    rectangle.set_location(random.nextInt(200), random.nextInt(200));
                    rectangle.set_fill_transparency(random.nextInt(255));
                    rectangle.set_rotate_angle(random.nextInt(180));
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        RenderingHints renderingHints1 = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        RenderingHints renderingHints2 = new RenderingHints(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(renderingHints1);
        g2d.setRenderingHints(renderingHints2);
        for (Rectangle rectangle : rectangles) {
            Graphics2D iDontTrustYou = (Graphics2D) g2d.create();
            rectangle.render(iDontTrustYou);
            iDontTrustYou.dispose();
        }
        g2d.dispose();
    }

}