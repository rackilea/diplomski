public class SlowDecline {

    public static void main(String[] args) {
        new SlowDecline();
    }
    private TestPane last;

    public SlowDecline() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                TestPane parent = new TestPane(Color.RED);
                TestPane tp = add(parent, Color.BLUE);
                tp = add(tp, Color.GREEN);
                tp = add(tp, Color.CYAN);
                tp = add(tp, Color.LIGHT_GRAY);
                tp = add(tp, Color.MAGENTA);
                tp = add(tp, Color.ORANGE);
                tp = add(tp, Color.PINK);

                last = tp;

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(parent);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (last != null) {
                            Container parent = last.getParent();
                            if (parent != null) {
                                parent.remove(last);
                                parent.repaint();
                                if (parent instanceof TestPane) {
                                    last = (TestPane) parent;
                                }
                            } else {
                                last = null;
                            }
                        } else {
                            (((Timer)e.getSource())).stop();
                        }
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();
            }
        });
    }

    public TestPane add(TestPane parent, Color color) {

        TestPane child = new TestPane(color);
        parent.add(child);
        return child;
    }

    public class TestPane extends JPanel {

        public TestPane(Color background) {
            setLayout(new BorderLayout());
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setBackground(background);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}