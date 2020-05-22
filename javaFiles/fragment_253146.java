public class CirclePaneTest {

    public static void main(String[] args) {
        new CirclePaneTest();
    }

    public CirclePaneTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                CirclePane circlePane = new CirclePane();
                circlePane.setLayout(new BorderLayout());
                circlePane.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            System.exit(0);
                        }
                    }
                });

                JLabel label = new JLabel("Look Ma, I'm a circle");
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);

                JFrame frame = new JFrame("Test");
                frame.setUndecorated(true);
                frame.setBackground(new Color(0, 0, 0, 0));
                frame.setContentPane(circlePane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(label);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CirclePane extends JPanel {

        public CirclePane() {
            setOpaque(false);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected int getRadius() {
            return Math.min(getWidth(), getHeight()) - 1;
        }

        @Override
        public Insets getInsets() {

            int radius = getRadius();
            int xOffset = (getWidth() - radius) / 2;
            int yOffset = (getHeight() - radius) / 2;
            Insets insets = new Insets(
                    radius / 6,
                    radius / 6,
                    radius / 6,
                    radius / 6);

            return insets;
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            int radius = getRadius();
            int xOffset = (getWidth() - radius) / 2;
            int yOffset = (getHeight() - radius) / 2;

            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(getBackground());
            g2d.fillOval(xOffset, yOffset, radius, radius);
            g2d.setColor(Color.GRAY);
            g2d.drawOval(xOffset, yOffset, radius, radius);
            g2d.dispose();

        }
    }
}