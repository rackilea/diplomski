import java.awt.*;

import javax.swing.*;

import java.awt.image.BufferedImage;
import java.util.Scanner;

public class BufferedImagePainting extends JFrame {

    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(800, 600, BufferedImage.TYPE_3BYTE_BGR);
        JPanel drawPanel = new DrawPanel(img);
        new InteractionThread(img, drawPanel).start();
        new BufferedImagePainting(drawPanel);
    }

    public BufferedImagePainting(final JPanel drawPanel) {
        super();
        setLayout(new GridLayout(1, 1));
        add(drawPanel);
        pack();
        setVisible(true);
    }

    private static class DrawPanel extends JPanel {
        private BufferedImage img;

        public DrawPanel(BufferedImage img) {
            this.img = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    }

    private static class InteractionThread extends Thread {

        private BufferedImage img;
        private JPanel drawPanel;

        public InteractionThread(BufferedImage img, JPanel drawPanel) {
            this.img = img;
            this.drawPanel = drawPanel;
        }

        @Override
        public void run() {
            @SuppressWarnings("resource")
            Scanner s = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a draw color and a fill color, separated by spaces");
                System.out.println("Enter colors as 6-digit hex number, i. e. 000000 = black, ffffff = white");
                Color drawColor = new Color(Integer.parseInt(s.next(), 16));
                Color fillColor = new Color(Integer.parseInt(s.next(), 16));
                System.out.println("Enter coordinates in form x y width height, separated by spaces");
                int x = s.nextInt();
                int y = s.nextInt();
                int w = s.nextInt();
                int h = s.nextInt();
                Graphics g = img.createGraphics();
                g.setColor(fillColor);
                g.fillRect(x, y, w, h);
                g.setColor(drawColor);
                g.drawRect(x, y, w, h);
                g.dispose();
                drawPanel.repaint();
            }
        }
    }
}