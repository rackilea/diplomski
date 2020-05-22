public class TransparentFrame {

    public static void main(String[] args) {
        new TransparentFrame();
    }

    public TransparentFrame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setUndecorated(true);
                frame.setContentPane(new ContentPane());

                String version = System.getProperty("java.version");
                System.out.println(version);
                if (version.startsWith("1.7")) {
                    frame.setBackground(new Color(0, 0, 0, 0));
                } else if (version.startsWith("1.6")) {
                    if (supportsPerAlphaPixel()) {
                        setOpaque(frame, false);
                    } else {
                        System.out.println("Per Pixel Alphering is not support with Java " + version);
                        System.exit(1);
                    }
                } else {
                    System.out.println("Per Pixel Alphering is not support with Java " + version);
                    System.exit(1);
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static boolean supportsPerAlphaPixel() {

        boolean support = false;

        try {

            Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
            support = true;

        } catch (Exception exp) {
        }

        return support;

    }

    public static void setOpaque(Window window, boolean opaque) {

        try {

            Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
            if (awtUtilsClass != null) {

                Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
                method.invoke(null, window, opaque);

            }

        } catch (Exception exp) {
        }

    }

    public class ContentPane extends JPanel {

        public ContentPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }

    public class ImagePane extends JPanel {

        private BufferedImage background;
        private BufferedImage offImage;
        private Ellipse2D offButton;
        private boolean mouseIn;

        public ImagePane() {
            setOpaque(false);
            try {
                background = ImageIO.read(new File("tamagotchi400.png"));
                offImage = ImageIO.read(new File("powerSmall.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            offButton = new Ellipse2D.Float(212, 330, 25, 25);
            MouseAdapter handler = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1) {
                        if (offButton.contains(e.getPoint())) {
                            Window window = SwingUtilities.getWindowAncestor(ImagePane.this);
                            if (window != null) {
                                window.dispose();
                            }
                        }
                    }
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    Cursor cursor = Cursor.getDefaultCursor();
                    if (offButton.contains(e.getPoint())) {
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                    }
                    setCursor(cursor);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mouseIn = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouseIn = false;
                    repaint();
                }
            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(400, 400) : new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2d.drawImage(background, x, y, this);
                if (mouseIn && offImage != null) {
                    g2d.drawImage(offImage, (int) offButton.getX(), (int) offButton.getY(), this);
                }
                g2d.dispose();
            }
        }
    }
}