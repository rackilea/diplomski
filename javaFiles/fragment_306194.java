package game;

import java.awt.Graphics;

public interface Displayable {
    public void paint(Graphics graphics);
}

package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rabbit implements Displayable {
    private int x, y;
    private Image image;

    public Rabbit(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        this.image = ImageIO.read(new File("RABBIT_FILE")); // Replace
                                                            // "RABBIT_FILE"
                                                            // with the image
                                                            // file you have
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, new ImageObserver() {
            public boolean imageUpdate(Image img, int infoflags, int x, int y,
                    int width, int height) {
                return false;
            }
        });

        /**
         * Optional: JDK 8 only:
         * 
         * graphics.drawImage(this.image, this.x, this.y, (Image img, int
         * infoflags, int x0, int y0, int width0, int height0) -> false);
         * //Lambda Expression
         */
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements Displayable {
    private int x, y;
    private Image image;

    public Player(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        this.image = ImageIO.read(new File("PLAYER_FILE")); // Replace
                                                            // "PLAYER_FILE"
                                                            // with the image
                                                            // file you have
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, new ImageObserver() {
            public boolean imageUpdate(Image img, int infoflags, int x, int y,
                    int width, int height) {
                return false;
            }
        });

        /**
         * Optional: JDK 8 only:
         * 
         * graphics.drawImage(this.image, this.x, this.y, (Image img, int
         * infoflags, int x0, int y0, int width0, int height0) -> false);
         * //Lambda Expression
         */
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

package game;

import java.awt.Graphics;

import javax.swing.JPanel;

public final class GamePanel extends JPanel {
    private static final long serialVersionUID = -385535147711891740L;
    private Player player;
    private Rabbit rabbit;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRabbit(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    public GamePanel(Player player, Rabbit rabbit) {
        this.setPlayer(player);
        this.setRabbit(rabbit);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.player.paint(g);
        this.rabbit.paint(g);
    }
}

package game;

import javax.swing.JFrame;

public final class Main {
    public static void main(String... args) {
        try {
            JFrame frame = new JFrame("Player & Rabbit Game"); // Or whatever
                                                                // title
            // you have in mind
            GamePanel panel = new GamePanel(new Player(0, 0), new Rabbit(0, 0));
            frame.add(panel);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(3);
            frame.setExtendedState(6);
        } catch (Exception e) {
            // Handle Exception if file is corrupted, unable to be read to an
            // image, or does not exist
        }
    }
}