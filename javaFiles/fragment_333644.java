import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TestIMage {

    public TestIMage() {

        JFrame frame = new JFrame();
        frame.add(new Player());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestIMage();
            }
        });
    }

    private class Player extends JPanel {

        private  int DIM_W;
        private  int DIM_H;

        private BufferedImage im;
        private Graphics gr;

        public void loadl() {
            try {
                im = ImageIO.read(TestIMage.class.getResource("/res/stackoverflow5.png"));
                DIM_W = im.getWidth();
                DIM_H = im.getHeight();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DIM_W, DIM_H);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            gr = g;
            g.drawImage(im, 0, 0, DIM_W, DIM_W, this);
        }

        public Player() {
            loadl();
        }
    }
}