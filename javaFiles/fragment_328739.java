public class MarkLayer {

    public static void main(String[] args) {
        new MarkLayer();
    }

    public MarkLayer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new GridBagLayout());

                    JLabel label = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/Miho_Small.png"))));
                    LayerUI<JLabel> layerUI = new MarkLayerUI();
                    JLayer<JLabel> layer = new JLayer<>(label, layerUI);

                    frame.add(layer);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public class MarkLayerUI extends LayerUI<JLabel> {

        private Map<JLayer, List<Point>> mapPoints;

        public MarkLayerUI() {
            mapPoints = new WeakHashMap<>(25);
        }

        @Override
        public void installUI(JComponent c) {
            System.out.println("install");
            super.installUI(c);
            JLayer layer = (JLayer) c;
            layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK);
        }

        @Override
        public void uninstallUI(JComponent c) {
            super.uninstallUI(c);
            mapPoints.remove((JLayer) c);
        }

        @Override
        protected void processMouseEvent(MouseEvent e, JLayer<? extends JLabel> l) {
            if (e.getID() == MouseEvent.MOUSE_CLICKED) {

                List<Point> points = mapPoints.get(l);
                if (points == null) {
                    points = new ArrayList<>(25);
                    mapPoints.put(l, points);
                }
                Point p = e.getPoint();
                p = SwingUtilities.convertPoint(e.getComponent(), p, l);
                points.add(p);
                l.repaint();

            }
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2d = (Graphics2D) g.create();
            super.paint(g2d, c);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
            List<Point> points = mapPoints.get((JLayer) c);
            if (points != null && points.size() > 0) {
                g2d.setColor(Color.RED);
                for (Point p : points) {
                    g2d.fillOval(p.x - 4, p.y - 4, 8, 8);
                }
            }
            g2d.dispose();
        }
    }
}