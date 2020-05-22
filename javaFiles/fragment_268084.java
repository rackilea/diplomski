public class TestMask {

    public static void main(String[] args) {
        new TestMask();
    }

    public TestMask() {
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
                frame.add(new ShapedPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ShapedPane extends JPanel {

        public ShapedPane() {
            setBackground(Color.GREEN);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.BLACK);
            g2d.fill(new RounedFrame(getWidth(), getHeight(), 10, 20));
            g2d.dispose();
        }
    }

    public class RounedFrame extends Path2D.Float {

        public RounedFrame(float width, float height, float thickness, float radius) {

            moveTo(0, 0);
            lineTo(width, 0);
            lineTo(width, height);
            lineTo(0, height);
            lineTo(0, 0);

            float innerWidth = width - thickness;
            float innerHeight = height - thickness;

            moveTo(thickness + radius, thickness);
            lineTo(innerWidth - radius, thickness);

            curveTo(innerWidth, thickness, innerWidth, thickness, innerWidth, thickness + radius);

            lineTo(innerWidth, innerHeight - radius);
            curveTo(innerWidth, innerHeight, innerWidth, innerHeight, innerWidth - radius, innerHeight);
            lineTo(thickness + radius, innerHeight);
            curveTo(thickness, innerHeight, thickness, innerHeight, thickness, innerHeight - radius);
            lineTo(thickness, thickness + radius);
            curveTo(thickness, thickness, thickness, thickness, thickness + radius, thickness);

            closePath();

            setWindingRule(WIND_EVEN_ODD);

        }
    }
}