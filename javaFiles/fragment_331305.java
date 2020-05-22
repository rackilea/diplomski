public class TestImageMap {

    private BufferedImage master;
    private BufferedImage masterMap;

    public static void main(String[] args) {
        new TestImageMap();
    }

    public TestImageMap() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {

                    master = ImageIO.read(getClass().getResource("/Master.png"));
                    masterMap = ImageIO.read(getClass().getResource("/MasterMap.png"));

                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new GridLayout(2, 1));
                    frame.add(new MapPane());
                    frame.add(new CoordPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);

                } catch (Exception exp) {
                    exp.printStackTrace();
                    System.exit(0);
                }
            }
        });
    }

    public void sendMoney() {
        JOptionPane.showMessageDialog(null, "Sending money :D");
    }

    public void sendMoreMoney() {
        JOptionPane.showMessageDialog(null, "Sending ALL your money 8D");
    }

    public abstract class AbstractImagePane extends JPanel {

        public AbstractImagePane() {

            MouseAdapter handler = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    doMouseClicked(e);
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    doMouseMoved(e);
                }
            };

            addMouseMotionListener(handler);
            addMouseListener(handler);
        }

        @Override
        public Dimension getPreferredSize() {
            return master == null ? super.getPreferredSize() : new Dimension(master.getWidth(), master.getHeight());
        }

        protected void doMouseClicked(MouseEvent evt) {
            if (evt.getButton() == MouseEvent.BUTTON1) {
                if (evt.getClickCount() == 1) {
                    Point p = evt.getPoint();
                    if (containsMoney(p)) {
                        sendMoney();
                    } else if (containsMoreMoney(p)) {
                        sendMoreMoney();
                    }
                }
            }
        }

        protected void doMouseMoved(MouseEvent evt) {
            Cursor cursor = Cursor.getDefaultCursor();
            Point p = evt.getPoint();
            if (containsMoney(p) || containsMoreMoney(p)) {
                cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
            }
            setCursor(cursor);
        }

        protected abstract boolean containsMoney(Point p);
        protected abstract boolean containsMoreMoney(Point p);

        protected Point normalize(Point p) {
            Point offset = getImageOffset();
            Point norm = new Point();
            norm.x = p.x - offset.x;
            norm.y = p.y - offset.y;
            return norm;
        }

        protected Point getImageOffset() {
            int width = getWidth() - 1;
            int height = getHeight() - 1;
            int x = (width - master.getWidth()) / 2;
            int y = (height - master.getHeight()) / 2;

            return new Point(x, y);

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (master != null) {
                Point offset = getImageOffset();
                g.drawImage(master, offset.x, offset.y, this);
            }
        }
    }

    public class MapPane extends AbstractImagePane {

        private Rectangle moneyBounds = new Rectangle(16, 24, 139, 36);
        private Rectangle moreMoneyBounds = new Rectangle(16, 70, 139, 34);

        @Override
        protected boolean containsMoney(Point p) {
            return moneyBounds.contains(normalize(p));
        }

        @Override
        protected boolean containsMoreMoney(Point p) {
            return moreMoneyBounds.contains(normalize(p));
        }
    }

    public class CoordPane extends AbstractImagePane {

        protected boolean contains(Point p, int rgb) {
            Point norm = normalize(p);
            return masterMap.getRGB(norm.x, norm.y) == rgb;
        }

        @Override
        protected boolean containsMoney(Point p) {
            int white = new Color(255, 255, 255).getRGB();
            return contains(p, white);
        }

        @Override
        protected boolean containsMoreMoney(Point p) {
            int red = new Color(255, 0, 0).getRGB();
            return contains(p, red);
        }
    }
}