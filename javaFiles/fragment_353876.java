public class SimpleBouncyBall {

    public static void main(String[] args) {
        new SimpleBouncyBall();
    }

    public SimpleBouncyBall() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CourtPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CourtPane extends JPanel {

        private Ball ball;
        private int speed = 5;

        public CourtPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Rectangle bounds = new Rectangle(new Point(0, 0), getSize());
                    if (ball == null) {
                        ball = new Ball(bounds);
                    }
                    speed = ball.move(speed, bounds);
                    repaint();
                }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            if (ball != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Point p = ball.getPoint();
                g2d.translate(p.x, p.y);
                ball.paint(g2d);
                g2d.dispose();
            }
        }

    }

    public class Ball {

        private Point p;
        private int radius = 12;

        public Ball(Rectangle bounds) {                
            p = new Point();
            p.x = 0;
            p.y = bounds.y + (bounds.height - radius) / 2;                
        }

        public Point getPoint() {
            return p;
        }

        public int move(int speed, Rectangle bounds) {                
            p.x += speed;
            if (p.x + radius >= (bounds.x + bounds.width)) {                    
                speed *= -1;
                p.x = ((bounds.x + bounds.width) - radius) + speed;                    
            } else if (p.x <= bounds.x) {
                speed *= -1;
                p.x = bounds.x + speed;                    
            }
            p.y = bounds.y + (bounds.height - radius) / 2;                
            return speed;                
        }

        public void paint(Graphics2D g) {
            g.setColor(Color.RED);
            g.fillOval(0, 0, radius, radius);
        }            
    }        
}