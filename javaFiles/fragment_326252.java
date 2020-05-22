import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI().createAndShowGUI();
            }
        });
    }
}

class GUI {

    JFrame f = new JFrame("Swing Paint Demo");

    public void createAndShowGUI() {
        System.out.printf("%nCreated GUI on EDT? "
                + SwingUtilities.isEventDispatchThread());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.setSize(640, 640);
        f.setVisible(true);

    }

}

class MyPanel extends JPanel {

    Player_1 player1;

    public MyPanel() {
        player1 = new Player_1(MyPanel.this);
    }

    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.printf("%nPaincomponent on GUI");

        player1.paintSquare(g);

    }

}

class Player_1 {

    public Image img_player1;
    public int int_x = 0;
    public int int_y = 1;
    public int int_w = 1;
    public int int_h = 1;
    JPanel panel;

    public Player_1(JPanel panel) {
        this.panel = panel;
        img_player1 = IOControl.getImage("player_1.png");
    }

    public void paintSquare(Graphics g) {
        g.drawImage(img_player1, 32, 32, 32, 32, panel);
    }
}

class IOControl {

    public static BufferedImage getImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(GUI.class.getResource(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return img;
    }
}