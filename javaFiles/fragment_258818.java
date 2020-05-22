package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawImage implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DrawImage());
    }

    @Override
    public void run() {
        Image image = new CreateImage(256, 256, 80).createImage();

        JFrame frame = new JFrame("Image of a circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new DrawingPanel(256, 256, image));

        frame.pack();
        frame.setVisible(true);
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = 1584647402715684757L;

        private Image image;

        public DrawingPanel(int width, int height, Image image) {
            this.image = image;
            this.setPreferredSize(new Dimension(width, height));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

    }

    public class CreateImage {

        private int width;
        private int height;
        private int radius;

        public CreateImage(int width, int height, int radius) {
            this.width = width;
            this.height = height;
            this.radius = radius;
        }

        public Image createImage() {
            int circleRadiusSquared = radius * radius;

            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);

            Graphics g = image.getGraphics();

            for (int i = 0; i < width; i++) {
                int idist = i - width / 2;
                for (int j = 0; j < height; j++) {
                    int jdist = j - height / 2;
                    int distSquared = idist * idist + jdist * jdist;
                    if (distSquared < circleRadiusSquared) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                    g.drawLine(i, j, i, j);
                }
            }

            g.dispose();

            return image;
        }
    }

}