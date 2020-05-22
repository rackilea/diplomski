public class LayoutTest implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new LayoutTest());
    }

    @Override
    public void run() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        JPanel north = new JPanel(new GridLayout(0, 1));
        for (int i = 0; i < 5; ++i) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(0, 25));
            p.setBorder(new LineBorder(Color.BLACK, 1));
            p.setBackground(Color.WHITE);
            north.add(p);
        }
        f.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setBackground(Color.RED);
        f.add(center, BorderLayout.CENTER);

        f.setSize(400, 400);
        f.setVisible(true);
    }
}