public class TestFullScreen {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                FullFrame frame = new FullFrame();
                frame.setUndecorated(true);
                frame.getContentPane().setBackground(Color.PINK);

                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] gs = ge.getScreenDevices();

                gs[0].setFullScreenWindow(frame);

            }
        });

    }

    public static class FullFrame extends JFrame {

        public FullFrame() {
            super();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(0);
                }
            });

        }
    }
}