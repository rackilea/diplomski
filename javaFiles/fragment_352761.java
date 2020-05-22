public class TestAnimation01 {

    public static void main(String[] args) {
        new TestAnimation01();
    }

    public TestAnimation01() {
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
                frame.add(new Fields());
                frame.setSize(400, 400);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Fields extends JPanel implements ActionListener {

        Timer tm = new Timer(125, this);
        double x = 250, y = 250, vel = 0.2, angle = 90;
        private int velX = 4;
        private int velY = 4;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.BLACK);
            g.setColor(Color.GREEN);
            g.fillRect((int) x, (int) y, 5, 5);
        }

        public void actionPerformed(ActionEvent e) {

            x += (velX * (float) Math.cos(Math.toRadians(angle - 90)));
            y += (velX * (float) Math.sin(Math.toRadians(angle - 90)));

            repaint();
        }

        public Fields() {

            setFocusable(true);

            InputMap im = getInputMap(WHEN_FOCUSED);
            ActionMap am = getActionMap();

            // left 37
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "goLeft");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "goRight");

            am.put("goLeft", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle--;
                    repaint();
                }
            });
            am.put("goRight", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    angle++;
                    repaint();
                }
            });

            tm.setRepeats(true);
            tm.setCoalesce(true);
            tm.start();

            requestFocusInWindow();

        }
    }
}