public class TestPane extends JPanel {

    private Point source;
    private Shape sourceShape;
    private List<Ping> pings;
    private List<Shape> destinations;

    private Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};

    private AnimationEngine engine;

    public TestPane() {
        source = new Point(10, 10);
        sourceShape = new Ellipse2D.Double(source.x - 5, source.y - 5, 10, 10);

        Dimension size = getPreferredSize();

        Random rnd = new Random();
        int quantity = 1 + rnd.nextInt(10);
        pings = new ArrayList<>(quantity);
        destinations = new ArrayList<>(quantity);
        for (int index = 0; index < quantity; index++) {
            int x = 20 + rnd.nextInt(size.width - 25);
            int y = 20 + rnd.nextInt(size.height - 25);

            Point toPoint = new Point(x, y);

            // Create the "ping"
            Color color = colors[rnd.nextInt(colors.length)];
            Ping ping = new Ping(source, toPoint, color);
            pings.add(ping);

            // Create the destination shape...
            Rectangle bounds = ping.getBounds();
            Shape destination = new Ellipse2D.Double(toPoint.x - (bounds.width / 2d), toPoint.y - (bounds.height / 2d), 10, 10);
            destinations.add(destination);
        }

        engine = new AnimationEngine(Duration.ofSeconds(10));
        engine.setListener(new AnimationEngine.AnimationEngineListener() {
            @Override
            public void animationEngineTicked(AnimationEngine source, double progress) {
                for (Ping ping : pings) {
                    ping.update(progress);
                }
                repaint();
            }
        });
        engine.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // This is probably overkill, but it will make the output look nicer ;)
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        // Lines first, these could be cached
        g2d.setColor(Color.LIGHT_GRAY);
        double fromX = sourceShape.getBounds2D().getCenterX();
        double fromY = sourceShape.getBounds2D().getCenterY();
        for (Shape destination : destinations) {
            double toX = destination.getBounds2D().getCenterX();
            double toY = destination.getBounds2D().getCenterY();
            g2d.draw(new Line2D.Double(fromX, fromY, toX, toY));
        }

        // Pings, so they appear above the line, but under the points
        for (Ping ping : pings) {
            ping.paint(this, g2d);
        }

        // Destination and source
        g2d.setColor(Color.BLACK);
        for (Shape destination : destinations) {
            g2d.fill(destination);
        }

        g2d.fill(sourceShape);

        g2d.dispose();
    }

}