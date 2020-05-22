public class TestAnimatedWindow {

    public static void main(String[] args) {
        new TestAnimatedWindow();
    }

    public TestAnimatedWindow() {
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
                frame.add(new AnimatedPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class AnimatedPane extends JPanel {

        private GridBagConstraints gbc = new GridBagConstraints();
        private Timer anim;
        private long startTime;
        private int duration = 1000;
        private Rectangle startBounds, targetBounds;
        private JPanel top;
        private JPanel bottom;
        private JSlider durationSlider;
        private JLabel durationLabel;
        private JPanel content;

        public AnimatedPane() {
            top = new JPanel();
            bottom = new JPanel(new GridBagLayout());
            content = new JPanel(new GridBagLayout());
            durationLabel = new JLabel("1000");
            durationSlider = new JSlider(125, 5000);
            durationSlider.setMajorTickSpacing(1000);
            durationSlider.setMinorTickSpacing(500);
            durationSlider.setPaintTicks(true);
            durationSlider.setValue(1000);

            GridBagConstraints gbcBottom = new GridBagConstraints();
            gbcBottom.weightx = 1;
            gbcBottom.fill = GridBagConstraints.HORIZONTAL;
            bottom.add(durationSlider, gbcBottom);
            gbcBottom.weightx = 0;
            gbcBottom.fill = GridBagConstraints.NONE;
            bottom.add(durationLabel, gbcBottom);

            durationSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int value = durationSlider.getValue();
                    durationLabel.setText(Integer.toString(value));
                }

            });

            setLayout(new BorderLayout());
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JButton grow = new JButton("Grow");
            top.add(grow, gbc);

            add(top, BorderLayout.NORTH);
            add(content);
            add(bottom, BorderLayout.SOUTH);

            grow.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Stop any animation...
                    anim.stop();
                    // Get the window...
                    Window window = SwingUtilities.windowForComponent(AnimatedPane.this);
                    // What's the windows current bounds...
                    startBounds = window.getBounds();

                    // Add a new component...
                    JPanel panel = new JPanel(new GridBagLayout());
                    panel.add(new JLabel("Boo"));
                    panel.setBorder(new LineBorder(Color.RED));
                    content.add(panel, gbc);

                    // Calculate the bounds we want the window to get to 
                    targetBounds = new Rectangle();
                    // Add in the insets of the windows borders
                    Insets insets = window.getInsets();
                    // Get out preferred size...
                    Dimension size = getPreferredSize();
                    // Add in the border size...
                    size.width += insets.left + insets.right;
                    size.height += insets.top + insets.bottom;
                    targetBounds.setSize(size);

                    // Calculate the viewable position...
                    // Get the viewable screen bounds...
                    Rectangle viewBounds = getScreenViewableBounds();
                    Point p = new Point();
                    // Calculate the center of the screen...
                    p.x = ((viewBounds.width - size.width) / 2) + viewBounds.x;
                    p.y = ((viewBounds.height - size.height) / 2) + viewBounds.y;
                    targetBounds.setLocation(p);

                    // Divisibale by 2, stop the animation jitters
                    if (targetBounds.width % 2 != 0) {
                        targetBounds.width++;
                    }
                    if (targetBounds.height % 2 != 0) {
                        targetBounds.height++;
                    }
                    // Get the time that the animation started...
                    startTime = System.currentTimeMillis();
                    // Get the duration of the animation...
                    duration = durationSlider.getValue();
                    // Start animation...
                    anim.restart();
                }

            });

            // Timer set to about 25 fps...
            anim = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Get the current timer
                    long now = System.currentTimeMillis();
                    // Calculate the difference between now and the start of the animation...
                    long diff = now - startTime;
                    // Get out window...
                    Window window = SwingUtilities.getWindowAncestor(AnimatedPane.this);
                    // The bounds of the window to use
                    Rectangle bounds = targetBounds;
                    // If we've not reached the end of animation cycle...
                    if (diff < duration) {
                        // Calculate the progress of the aniamtion...
                        // That is, the amount of time the animation has been running for
                        // and the duration
                        double progress = (double) diff / (double) duration;
                        // Calculate the bounds over the progress range...
                        bounds = calculateProgress(startBounds, targetBounds, progress);
                        // Divisiable by 2..
                        if (bounds.width % 2 != 0) {
                            bounds.width++;
                        }
                        if (bounds.height % 2 != 0) {
                            bounds.height++;
                        }
                    } else {
                        // Stop the timer..
                        ((Timer) e.getSource()).stop();
                    }
                    // Update the windows bounds
                    window.setBounds(bounds);
                }
            });
            anim.setRepeats(true);
            anim.setCoalesce(true);
            anim.setInitialDelay(0);
        }
    }

    public static Rectangle calculateProgress(Rectangle startBounds, Rectangle targetBounds, double progress) {
        Rectangle bounds = new Rectangle();
        if (startBounds != null && targetBounds != null) {
            bounds.setLocation(calculateProgress(startBounds.getLocation(), targetBounds.getLocation(), progress));
            bounds.setSize(calculateProgress(startBounds.getSize(), targetBounds.getSize(), progress));
        }
        return bounds;
    }

    public static Dimension calculateProgress(Dimension startSize, Dimension targetSize, double progress) {
        Dimension size = new Dimension();
        if (startSize != null && targetSize != null) {
            size.width = calculateProgress(startSize.width, targetSize.width, progress);
            size.height = calculateProgress(startSize.height, targetSize.height, progress);
        }
        return size;
    }

    public static Point calculateProgress(Point startPoint, Point targetPoint, double progress) {
        Point point = new Point();
        if (startPoint != null && targetPoint != null) {
            point.x = calculateProgress(startPoint.x, targetPoint.x, progress);
            point.y = calculateProgress(startPoint.y, targetPoint.y, progress);
        }
        return point;
    }

    public static int calculateProgress(int startValue, int endValue, double fraction) {
        int value = 0;
        int distance = endValue - startValue;
        value = (int) ((float) distance * fraction);
        value += startValue;
        return value;
    }

    public static Rectangle getScreenViewableBounds() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return getScreenViewableBounds(gd);
    }

    public static Rectangle getScreenViewableBounds(GraphicsDevice gd) {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        if (gd != null) {
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            bounds = gc.getBounds();
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);

            bounds.x += insets.left;
            bounds.y += insets.top;
            bounds.width -= (insets.left + insets.right);
            bounds.height -= (insets.top + insets.bottom);
        }
        return bounds;
    }
}