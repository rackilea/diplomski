import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View {
    private static final char[] DIRECTION_NAME = { 'N', 'E', 'S', 'W' };
    private static final int[] DIRECTION_X = { 0, 1, 0, -1 };
    private static final int[] DIRECTION_Y = { 1, 0, -1, 0 };
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;

    private final JLabel label;
    private final ImageIcon[][][] images;
    private int x;
    private int y;
    private int direction;

    public View() throws IOException {
        images = new ImageIcon[WIDTH][HEIGHT][4];
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
                for(int direction = 0; direction < 4; ++direction) {
                    String name = x + "_" + y + "_" + DIRECTION_NAME[direction] + ".jpg";
                    images[x][y][direction] = new ImageIcon(ImageIO.read(View.class.getResourceAsStream(name)));
                }
            }
        }

        label = new JLabel();
        label.setIcon(images[0][0][0]);

        JFrame frame = new JFrame("View");
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        label.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    direction = (direction + 3) % 4;
                    break;
                case KeyEvent.VK_RIGHT:
                    direction = (direction + 1) % 4;
                    break;
                case KeyEvent.VK_UP:
                {
                    int newX = x + DIRECTION_X[direction];
                    int newY = y + DIRECTION_Y[direction];
                    if(newX >= 0 && newX < WIDTH && newY >= 0 && newY < HEIGHT) {
                        x = newX;
                        y = newY;
                    }
                    break;
                }
                }
                label.setIcon(images[x][y][direction]);
            }
        });
        label.requestFocus();
    }

    public static void main(String[] args) throws IOException {
        new View();
    }
}