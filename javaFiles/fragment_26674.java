public class TestLocation {

    public static void main(String[] args) {
        new TestLocation();
    }

    public TestLocation() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new LocationPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LocationPane extends JPanel {

        private JLabel label;

        public LocationPane() {
            setLayout(new GridBagLayout());
            label = new JLabel("A Label");
            add(label);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // While this works, really, don't do this, in paint methods
            // it's expensive and will slow down your system ;)
            Point loc = label.getLocation();
            Point pos = label.getLocationOnScreen();
            Window win = SwingUtilities.getWindowAncestor(this);
            Point wPos = win.getLocationOnScreen();
            Point wLoc = win.getLocation();

            Point rPos = SwingUtilities.convertPoint(label, label.getLocation(), win);
            JRootPane rootPane = SwingUtilities.getRootPane(this);
            Point cPos = SwingUtilities.convertPoint(label, loc, rootPane.getContentPane());
            Point wrPos = SwingUtilities.convertPoint(label, loc, win);

            FontMetrics fm = g2d.getFontMetrics();
            int rowHeight = fm.getHeight();

            String[] messages = new String[]{
                "Label.location = " + loc.x + "x" + loc.y,
//                "Label.locationOnScreen = " + pos.x + "x" + pos.y,
//                "Window.location = " + wLoc.x + "x" + wLoc.y,
//                "Window.locationOnScreen = " + wPos.x + "x" + wPos.y,
                "RelativeTo.Window = " + wrPos.x + "x" + wrPos.y,
                "RelativeTo.RootPane = " + rPos.x + "x" + rPos.y,
                "RelativeTo.ContentPane = " + cPos.x + "x" + cPos.y,
            };

            int y = 0;
            for (String msg : messages) {
                g2d.drawString(msg, 0, y + fm.getAscent());
                y += rowHeight;
            }

        }

    }

}