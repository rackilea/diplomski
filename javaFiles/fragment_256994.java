public class TestPaintTimer {

    public static void main(String[] args) {
        new TestPaintTimer();
    }

    public TestPaintTimer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new GradientPanel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class GradientPanel extends JPanel {

        private Color startColor = Color.RED;
        private Color endColor = Color.BLUE;
        private float progress = 0f;
        private float direction = 0.1f;

        public GradientPanel() {
            Timer timer = new Timer(125, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    progress += direction;
                    if (progress > 1f) {
                        direction *= -1;
                        progress = 1f;
                    } else if (progress < 0) {
                        direction *= -1;
                        progress = 0f;
                    }

                    startColor = calculateProgress(Color.RED, Color.BLUE, progress);
                    endColor = calculateProgress(Color.BLUE, Color.RED, progress);

                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            LinearGradientPaint lgp = new LinearGradientPaint(
                            new Point(0, 0),
                            new Point(0, getHeight()),
                            new float[]{0f, 1f},
                            new Color[]{startColor, endColor});
            g2d.setPaint(lgp);
            g2d.fill(new Rectangle(getWidth(), getHeight()));
            g2d.dispose();
        }

        public Color calculateProgress(Color startValue, Color endValue, float fraction) {
            int sRed = startValue.getRed();
            int sGreen = startValue.getGreen();
            int sBlue = startValue.getBlue();
            int sAlpha = startValue.getAlpha();

            int tRed = endValue.getRed();
            int tGreen = endValue.getGreen();
            int tBlue = endValue.getBlue();
            int tAlpha = endValue.getAlpha();

            int red = calculateProgress(sRed, tRed, fraction);
            int green = calculateProgress(sGreen, tGreen, fraction);
            int blue = calculateProgress(sBlue, tBlue, fraction);
            int alpha = calculateProgress(sAlpha, tAlpha, fraction);

            return new Color(red, green, blue, alpha);
        }

        public int calculateProgress(int startValue, int endValue, float fraction) {
            int value = 0;
            int distance = endValue - startValue;
//        value = Math.round((float)distance * fraction);
            value = (int) ((float) distance * fraction);
            value += startValue;

            return value;
        }

    }

}