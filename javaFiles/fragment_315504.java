public class SimpleAnimationTest {

    private Rectangle box = new Rectangle(0, 90, 10, 10);
    private int dx = 4;

    public static void main(String[] args) {
        new SimpleAnimationTest();
    }

    public SimpleAnimationTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new SimplePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SimplePane extends JPanel {

        public SimplePane() {

            setDoubleBuffered(true);

            Timer timer = new Timer(1000 / 300, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    box.x += dx;
                    if (box.x + box.width > getWidth()) {
                        box.x = getWidth() - box.width;
                        dx *= -1;
                    } else if (box.x < 0) {
                        box.x = 0;
                        dx *= -1;
                    }
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            super.paintComponent(g2d);
            box.y = (getHeight() - box.height) / 2;
            g2d.setColor(Color.RED);
            g2d.fill(box);
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
}