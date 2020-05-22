import java.awt.*;
import javax.swing.*;

public class MainGame {
    public static final String NAME = "Physics - Projectile Motion Example";
    public static final int HEIGHT = 160;
    public static final int WIDTH = HEIGHT * 16 / 9;
    public static final int SCALE = 4;

    public MainGame() {
        run();
    }

    public void run() {
        JFrame frame = new JFrame(MainGame.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JPanel options = new JPanel();
        options.add(new JLabel("Options"));
        JPanel game = new JPanel();
        game.add(new JLabel("Game"));

        frame.setSize(new Dimension ( WIDTH * SCALE, HEIGHT * SCALE ));

        frame.add(game, BorderLayout.CENTER);
        frame.add(options, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGame();
    }
}