public class CustomPaintingInHalfFrame {
    int x, y;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 200;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomPaintingInHalfFrame().gui();
            }
        });
    }

    @SuppressWarnings("serial")
    public void gui() {
        JFrame jframe = new JFrame("Title");

        DrawCircle dc = new DrawCircle(WIDTH / 2, HEIGHT);

        dc.setBorder(BorderFactory.createLineBorder(Color.RED));

        jframe.add(dc, BorderLayout.WEST);

        jframe.setSize(WIDTH, HEIGHT);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);

    }
}