public class TestZooming {

    public static void main(String[] args) {
        new TestZooming();
    }

    public TestZooming() {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException classNotFoundException) {
                } catch (InstantiationException instantiationException) {
                } catch (IllegalAccessException illegalAccessException) {
                } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                }

                JFrame frame = new JFrame();
                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setLayout(new BorderLayout());
                final ZoomPane pane = new ZoomPane();
                frame.add(new JScrollPane(pane));
                frame.setVisible(true);

                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        pane.centerInViewport();
                    }

                });

            }
        });

    }

    protected class ZoomPane extends JPanel {

        private Image background;
        private Image scaled;
        private float zoom = 1f;

        private Dimension scaledSize;
        private JViewport con;

        public ZoomPane() {

            try {
                background = ImageIO.read(new File("..."));
                scaled = background;
                scaledSize = new Dimension(background.getWidth(this), background.getHeight(this));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "plus");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, InputEvent.SHIFT_DOWN_MASK), "plus");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "minus");

            am.put("plus", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setZoom(getZoom() + 0.1f);
                }
            });
            am.put("minus", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setZoom(getZoom() - 0.1f);
                }
            });

            setFocusable(true);
            requestFocusInWindow();

        }

        @Override
        public void addNotify() {

            super.addNotify();

        }

        public float getZoom() {
            return zoom;
        }

        public void setZoom(float value) {
            if (zoom != value) {
                zoom = value;

                if (zoom < 0) {
                    zoom = 0f;
                }

                int width = (int) Math.floor(background.getWidth(this) * zoom);
                int height = (int) Math.floor(background.getHeight(this) * zoom);
                scaled = background.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                scaledSize = new Dimension(width, height);

                if (getParent() instanceof JViewport) {

                    int centerX = width / 2;
                    int centerY = height / 2;

                    JViewport parent = (JViewport) getParent();
                    Rectangle viewRect = parent.getViewRect();
                    viewRect.x = centerX - (viewRect.width / 2);
                    viewRect.y = centerY - (viewRect.height / 2);
                    scrollRectToVisible(viewRect);
                }

                invalidate();
                repaint();

            }
        }

        @Override
        public Dimension getPreferredSize() {

            return scaledSize;

        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);

            if (scaled != null) {

                g.drawImage(scaled, 0, 0, this);

            }

        }

        protected void centerInViewport() {

            Container container = getParent();
            if (container instanceof JViewport) {

                JViewport port = (JViewport) container;
                Rectangle viewRect = port.getViewRect();

                int width = getWidth();
                int height = getHeight();

                viewRect.x = (width - viewRect.width) / 2;
                viewRect.y = (height - viewRect.height) / 2;

                scrollRectToVisible(viewRect);

            }

        }
    }
}