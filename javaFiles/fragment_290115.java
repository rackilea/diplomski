package stackoverflow.answers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class JPanelPaint {
    JPanel panel;
    JFrame frame;
    BufferedImage image;

    public JPanelPaint() {
        image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j=0; j < image.getHeight(); j++) {
                /* I'm just initializing the image with an arbitrary color (white in this case), you can easily change this. */
                image.setRGB(i, j, new Color((int)(255 ), (int)(255 ), (int)(255 )).getRGB());
            }
        }

        frame = new JFrame("JPanel Paint");
        panel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Rectangle rect = g.getClipBounds();
                g.setColor(Color.white);
                g.fillRect(rect.x, rect.y, rect.width, rect.height);
                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j=0; j < image.getHeight(); j++) {
                        /* Set the color of the "quadpixel" to that of the original cell on the image. */
                        g.setColor(new Color(image.getRGB(i, j)));
                        g.fillRect(j*4, i*4, 4, 4);
                    }
                }


            }
        };

        panel.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) { }

            @Override
            public void mouseEntered(MouseEvent arg0) { }

            @Override
            public void mouseExited(MouseEvent arg0) { }

            @Override
            public void mousePressed(MouseEvent arg0) {
                /* Y and X are swapped, just a quirk in the JRE */
                /* I'm just setting the pixel with an arbitrary color (black in this case), you can easily change this. */
                image.setRGB(arg0.getY() / 4, arg0.getX() / 4, new Color(0, 0, 0).getRGB());
                panel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent arg0) { }

        });

        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent arg0) {
                /* Y and X are swapped, just a quirk in the JRE */
                /* I'm just setting the pixel with an arbitrary color (black in this case), you can easily change this. */
                image.setRGB(arg0.getY() / 4, arg0.getX() / 4, new Color(0, 0, 0).getRGB());
                panel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent arg0) { }

        });

        panel.setPreferredSize(new Dimension(200, 200));

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.repaint();
    }

    public static void main(String[] args) {
        new JPanelPaint();
    }
}