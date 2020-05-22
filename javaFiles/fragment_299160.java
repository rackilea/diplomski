public class ClikerGame {

    private int x, y, xa = 2, ya = 2;
    private Clicker clicker;

    private Timer timer;

    public ClikerGame(Clicker clicker) {
        this.clicker = clicker;

        timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    x += xa;
                    y += ya;
                    if (x < 0 || x > 700 - 20) {

                        Music.music(1);

                        xa = -xa;
                    } else if (y < 0 || y > 500 - 20) {

                        Music.music(1);

                        ya = -ya;

                    }

                    Thread.sleep(15);

                    clicker.ball.setBounds(x, y, 30, 30);
                    clicker.ball.getParent().repaint();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error 1");

                }
            }
        });
    }

    public void start() {
        if (!timer.isRunning()) {
            Music.music(2);
            timer.start();
        }
    }

    public void stop() {
        timer.stop();
        // Stop the music
    }
}