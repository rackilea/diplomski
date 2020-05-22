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
                frame.add(new MaskedPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class MaskedPane extends JPanel {

        public MaskedPane() {
            setBackground(Color.RED);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            BufferedImage outter = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = outter.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
            BufferedImage inner = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            g2d = inner.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.BLACK);
            g2d.fillRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 20, 20);
            g2d.dispose();

            BufferedImage masked = applyMask(outter, inner, AlphaComposite.DST_OUT);
            g.drawImage(masked, 0, 0, this);

        }

        public BufferedImage applyMask(BufferedImage sourceImage, BufferedImage maskImage, int method) {
            BufferedImage maskedImage = null;
            if (sourceImage != null) {

                int width = maskImage.getWidth();
                int height = maskImage.getHeight();

                maskedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D mg = maskedImage.createGraphics();

                int x = (width - sourceImage.getWidth()) / 2;
                int y = (height - sourceImage.getHeight()) / 2;

                mg.drawImage(sourceImage, x, y, null);
                mg.setComposite(AlphaComposite.getInstance(method));
                mg.drawImage(maskImage, 0, 0, null);
                mg.dispose();
            }

            return maskedImage;
        }

        public BufferedImage applyMask(BufferedImage sourceImage, BufferedImage maskImage) {
            return (BufferedImage) applyMask(sourceImage, maskImage, AlphaComposite.DST_IN);
        }
    }
}