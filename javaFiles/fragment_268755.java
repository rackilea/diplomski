public class TestSpoke {

    public static void main(String[] args) {
        new TestSpoke();
    }

    public TestSpoke() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel {

        public static final int CIRCLE_COUNT = 16;
        public static final int SEGMENT_COUNT = 80;
        private Map<Integer, List<Shape>> mapWheel;
        private Map<Point, Color> mapColors;

        public TestPane() {
            mapColors = new HashMap<>(CIRCLE_COUNT * SEGMENT_COUNT);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    Map<Integer, List<Shape>> mapWheel = getWheel();

                    for (Integer circle : mapWheel.keySet()) {
                        List<Shape> segments = mapWheel.get(circle);
                        for (int index = 0; index < segments.size(); index++) {
                            Shape segment = segments.get(index);
                            if (segment.contains(e.getPoint())) {
                                mapColors.put(new Point(circle, index), Color.RED);
                                repaint();
                                break;
                            }
                        }
                    }
                }
            });
        }

        @Override
        public void invalidate() {
            mapWheel = null;
            super.invalidate();
        }

        protected float getRadius() {
            return Math.min(getWidth(), getHeight());
        }

        /**
         * This builds a wheel (if required) made of segments.
         * @return 
         */
        protected Map<Integer, List<Shape>> getWheel() {
            if (mapWheel == null) {
                mapWheel = new HashMap<>(CIRCLE_COUNT);

                // The current radius
                float radius = getRadius();
                // The radius of each individual circle...
                float circleRadius = radius / CIRCLE_COUNT;
                // The range of each segment
                float extent = 360f / SEGMENT_COUNT;
                for (int circle = 0; circle < CIRCLE_COUNT; circle++) {
                    float startAngle = 0;
                    List<Shape> segments = new ArrayList<>(SEGMENT_COUNT);
                    mapWheel.put(circle, segments);

                    // Calculate the "translation" to place each segement in the
                    // center of the screen
                    float innerRadius = circleRadius * circle;
                    float x = (getWidth() - innerRadius) / 2;
                    float y = (getHeight() - innerRadius) / 2;
                    for (int seg = 0; seg < SEGMENT_COUNT; seg++) {
                        // Generate a Segment shape
                        Segment segment = new Segment(circleRadius * circle, circleRadius, startAngle, extent);
                        startAngle += extent;

                        // We translate the segment to the screen space
                        // This will make it faster to paint and check for mouse clicks
                        PathIterator pi = segment.getPathIterator(AffineTransform.getTranslateInstance(x, y));
                        Path2D path = new Path2D.Float();
                        path.append(pi, true);
                        segments.add(path);
                    }
                }
            }

            return mapWheel;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            Map<Integer, List<Shape>> mapWheel = getWheel();
            for (Integer circle : mapWheel.keySet()) {

                List<Shape> segments = mapWheel.get(circle);
                for (int index = 0; index < segments.size(); index++) {
                    Shape segment = segments.get(index);

                    Color color = mapColors.get(new Point(circle, index));
                    if (color != null) {
                        g2d.setColor(color);
                        g2d.fill(segment);
                    }
                    g2d.setColor(Color.BLACK);
                    g2d.draw(segment);
                }
            }

            g2d.dispose();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public static class Segment extends Path2D.Float {

        public Segment(float radius, float thickness, float extent) {
            this(radius, thickness, 0f, extent);
        }

        public Segment(float radius, float thickness, float startAngle, float extent) {
            // Basically, we want to draw the outter edge from a to b angle,
            // draw the connecting line from the outter to the inner,
            // draw the inner from b to a angel and
            // draw the connecting line from the inner to out the outter

            // We want to span about 30 degrees, with a small gap...
            // I want the gap to be a factor of the radius

            Arc2D.Float outter = new Arc2D.Float(0, 0, radius, radius, startAngle, extent, Arc2D.OPEN);
            Arc2D.Float inner = new Arc2D.Float(thickness / 2f, thickness / 2f, radius - thickness, radius - thickness, startAngle + extent, -extent, Arc2D.OPEN);

            append(outter, true);

            float angel = startAngle + extent;
            Point2D p1 = getPointOnEdge(angel, radius);
            Point2D p2 = getPointOnEdge(angel, radius - thickness);
            // We need to adjust in for the change in the radius
            p2.setLocation(p2.getX() + (thickness / 2f), p2.getY() + (thickness / 2f));
            lineTo(p2.getX(), p2.getY());

            append(inner, true);

            angel = startAngle;
            p1 = getPointOnEdge(angel, radius);
            p2 = getPointOnEdge(angel, radius - thickness);
            p2.setLocation(p2.getX() + (thickness / 2f), p2.getY() + (thickness / 2f));
            lineTo(p1.getX(), p1.getY());

            closePath();
        }

        public Point2D getPointOnEdge(float angel, float radius) {
            angel -= 90;

            float x = radius / 2f;
            float y = radius / 2f;

            double rads = Math.toRadians((angel + 90));

            // This determins the length of tick as calculate from the center of
            // the circle.  The original code from which this derived allowed
            // for a varible length line from the center of the cirlce, we
            // actually want the opposite, so we calculate the outter limit first
            float fullLength = (radius / 2f);

            // Calculate the outter point of the line
            float xPosy = (float) (x + Math.cos(rads) * fullLength);
            float yPosy = (float) (y - Math.sin(rads) * fullLength);

            return new Point2D.Float(xPosy, yPosy);
        }
    }
}