import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class BlockBlinking extends JComponent {
    BufferedImage image;
    boolean showImage;
    int x = -1;
    int y = -1;
    int imageW = 20;
    int imageH = 20;

    Random r;
    private Timer timer;
    Color imageColor=null;

    BlockBlinking() {
        {
            try
            {
                File sourceimage = new File("ball.gif");
                image = ImageIO.read(sourceimage);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            this.addMouseListener(new MyMouseListener());

            r = new Random();
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    if (image != null) {
                        if (!showImage) {
                            int w = image.getWidth();
                            int h = image.getHeight();
                            int rx = getWidth() - w;
                            int ry = getHeight() - h;
                            if (rx > -1 && ry > -1) {
                                x = r.nextInt(rx);
                                y = r.nextInt(ry);
                            }
                        }
                        showImage = !showImage;
                        repaint();
                    }
                }
            };
            timer = new Timer(500, listener);
            timer.start();

            setPreferredSize(new Dimension(500, 400));
            JOptionPane.showMessageDialog(null, this);
            timer.stop();

        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (image != null) {

            if(imageColor != null){
                Graphics imageGraphic =image.createGraphics();
                imageGraphic.setColor(imageColor);
                imageGraphic.fillRect(0, 0, image.getWidth(), image.getHeight());
            }
            g.drawImage(image, x, y,imageW,imageH, this);
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BlockBlinking();
            }
        });
    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getX() >= x && e.getX() <= x + imageW && e.getY() >= y && e.getY() <= y + imageH) {
                imageColor = Color.BLACK;
                repaint();
                timer.stop();
            }

        }
    }
}