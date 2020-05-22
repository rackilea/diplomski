public class BadPaint01 {

    public static void main(String[] args) {
        new BadPaint01();
    }

    public BadPaint01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                Image Icon = Toolkit.getDefaultToolkit().getImage("Images/lol.jpg");
                frame.setIconImage(Icon);
                frame.setUndecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new GUI());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class GUI extends JPanel {

        private Image Background = null;
        private static Point Offset = new Point();

        public GUI() {
            AddListeners();
            SetCustomTheme();
            LoadBackground();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        private void Layout() {
            GroupLayout Info = new GroupLayout(this);
            setLayout(Info);
            JButton Button = new JButton();

            Info.setHorizontalGroup(
                    Info.createSequentialGroup()
                    .addComponent(Button));

            Info.setVerticalGroup(
                    Info.createParallelGroup()
                    .addComponent(Button));
        }

        private void SetCustomTheme() {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
        }

        private void LoadBackground() {
            try {
                Background = ImageIO.read(getClass().getResource("Images/meh.png"));
            } catch (Exception Ex) {
            }
        }

        private void AddListeners() {
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Offset.x = e.getX();
                    Offset.y = e.getY();
                }
            });

            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Point p = getLocation();
                    setLocation(p.x + e.getX() - Offset.x, p.y + e.getY() - Offset.y);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
            g.drawImage(Background, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
}