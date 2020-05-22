public class QuickTestPaintPane {

    public static void main(String[] args) {
        new QuickTestPaintPane();
    }

    public QuickTestPaintPane() {
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

                Viewer v = new Viewer();
                v.setup();

            }
        });
    }

    public class Viewer implements ActionListener {

        public JFrame frame;
        public JButton drawShoot;
        public boolean draw;
//        public Game game;
        public graphic graphic;
        public TimerTask timert;
        public Timer timer;

        public Viewer() {
            draw = true;
//            game = new Game();
        }

        public void setup() {
            frame = new JFrame("Laser Stimulator");
            drawShoot = new JButton("Edit Mode");
            graphic = new graphic();
//            graphic.repaint();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(300, 300, 600, 600);
//            Container contentPane = frame.getContentPane();
            SpringLayout layout = new SpringLayout();
            frame.setLayout(layout);
            drawShoot.addActionListener(this);
            timert = new TimerTask() {
                @Override
                public void run() {
                }
            };
            timer = new Timer();
            timer.scheduleAtFixedRate(timert, 0, 1000 / 30);
            frame.add(graphic);
            layout.putConstraint(SpringLayout.NORTH, graphic, 0, SpringLayout.NORTH, frame.getContentPane());
            layout.putConstraint(SpringLayout.WEST, graphic, 0, SpringLayout.WEST, frame.getContentPane());
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == drawShoot) {
                draw = !draw;
                drawShoot.setText((draw) ? "Edit Mode" : "Shoot Mode");
            }
        }
    }

    public class graphic extends JPanel {

        private static final long serialVersionUID = -3458717449092499931L;
//        public Game game;

//        public graphic(Game game) {
        public graphic() {
//            this.game = game;
            this.setPreferredSize(new Dimension(400, 400));
            this.setBackground(Color.RED);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.drawLine(0, 0, getWidth(), getHeight());
//            for (Line l : game.mirrors) {
//                g.setColor(Color.BLACK);
//                g.drawLine(l.start.x, l.start.y, l.end.x, l.end.y);
//            }
        }
    }
}