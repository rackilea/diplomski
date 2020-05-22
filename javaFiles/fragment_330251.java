import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.*;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

class SpriteSheetManager {

    private BufferedImage spriteSheet;
    int cols;
    int rows;

    public SpriteSheetManager() {
        setSpriteSheet();
    }

    public void setSpriteSheet() {
        try {
            spriteSheet = ImageIO.read(
                    new URL("http://s8.postimg.org/vso6oed91/spritesheet.png"));
            setColsAndRows(3, 3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public void setColsAndRows(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public Image getSprite(int x, int y) {
        Image sprite = null;
        try {
            sprite = spriteSheet.getSubimage(
                    x * spriteSheet.getWidth() / cols,
                    y * spriteSheet.getHeight() / rows,
                    spriteSheet.getWidth() / cols,
                    spriteSheet.getHeight() / rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sprite;
    }
}

class Ideone {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestSpriteSheet();
            }
        });
    }

}

class TestSpriteSheet extends JFrame {

    private static final long serialVersionUID = 1L;
    private SpriteSheetManager ss;

    public TestSpriteSheet() {
        super("Testing SpriteSheets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        ss = new SpriteSheetManager();

        add(new PanelSprite(this, ss));
        pack();
        setSize(200, 200);
        this.setVisible(true);
    }
}

class PanelSprite extends JPanel {

    private long runningTime = 0;
    private int fps = 10;
    private boolean stop = false;
    private SpriteSheetManager ss;
    private TestSpriteSheet temp;
    private Timer t;
    int count = 0;
    long time = 50000;

    public PanelSprite(TestSpriteSheet test, SpriteSheetManager sm) {
        ss = sm;
        temp = test;
        init();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        animate_with_gfx(g);
    }

    public void init() {
        t = new Timer((int) (1000 / fps), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!stop) {
                    repaint();
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        t.setRepeats(true);
        t.setDelay((int) (1000 / fps));
        t.start();
    }

    public void animate_with_gfx(Graphics g) {
        if (runningTime <= time) {
            Image img = ss.getSprite((count % 9) % 3, (count % 9) / 3);
            g.drawImage(img, 40, 40, this);
            count++;
            runningTime += (1000 / fps);
        } else {
            stop = true;
        }
    }
}