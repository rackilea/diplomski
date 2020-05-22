public class BucketFill {

    public static void main(String[] args) {
        new BucketFill();
    }

    public BucketFill() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<List<Point>> points;

        public TestPane() {
            points = new ArrayList<>(25);

            MouseAdapter ma = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    List<Point> newShape = new ArrayList<>(25);
                    newShape.add(e.getPoint());
                    points.add(newShape);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    List<Point> newShape = points.get(points.size() - 1);
                    newShape.add(e.getPoint());
                    repaint();
                }
            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (points.size() > 0) {

                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
                g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

                g2d.setColor(Color.BLUE);
                List<Shape> shapes = new ArrayList<>(25);
                for (List<Point> subPoints : points) {

                    if (subPoints.size() > 0) {

                        List<Point> proxy = new ArrayList<>(subPoints);

                        Path2D path = new Path2D.Float();
                        Point startPoint = proxy.remove(0);
                        path.moveTo(startPoint.x, startPoint.y);
                        for (Point p : proxy) {
                            path.lineTo(p.x, p.y);
                        }
                        path.closePath();
                        shapes.add(path);
                        path = null;

                    }

                }

                for (Shape master : shapes) {
                    Area area = new Area(master);
                    for (Shape inner : shapes) {
                        if (inner != master) {
                            area.subtract(new Area(inner));
                        }
                    }
                    g2d.setColor(Color.RED);
                    g2d.fill(area);
                    g2d.setColor(Color.BLACK);
                    g2d.draw(area);
                }

                g2d.dispose();

            }
        }
    }
}