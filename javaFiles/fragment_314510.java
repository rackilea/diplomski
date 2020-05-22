public class ChangingCircle {

    Color color = Color.RED;
    MyPanel panel = new MyPanel();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ChangingCircle gui = new ChangingCircle();
            gui.go();
        });
    }

    public void go() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        Random r = new Random();
        Timer timer = new Timer(r.nextInt(5000) + 1000, new ActionListener() {

            public void actionPerformed(ActionEvent ev) {

                System.out.println("Timer");
                color = Color.GREEN;
                panel.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    class MyPanel extends JPanel {

        private int size = 100, loc = 100;

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.setColor(color);
            g.fillOval(loc, loc, size, size);
        }

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(size + loc, size + loc);
        }
    }
}