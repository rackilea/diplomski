package snippet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Snippet implements Runnable {

    private JFrame frame;

    private List<BufferedImage> imageList;

    public Snippet() {
        imageList = new ArrayList<BufferedImage>();
        new DrawImage().createImages();
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setTitle("ALevelUp 0.0.1 Alpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel p = new DrawingPanel();
        frame.add(p);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        System.out.println(frame.getHeight() + "," + frame.getWidth());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Snippet());
    }

    public class DrawingPanel extends JPanel {

        private static final long   serialVersionUID    = 
                2535522354552193273L;

        public DrawingPanel() {
            this.setPreferredSize(new Dimension(550, 350));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = 50;
            int y = 50;

            for (int i = 0; i < 2; i++) {
                BufferedImage image = null;
                for (int j = 0; j < 2; j++) {
                    image = imageList.get(i * 2 + j);
                    g.drawImage(image, x, y, this);
                    x += image.getWidth() + 50;
                }
                x = 50;
                y += image.getHeight() + 50;
            }
        }
    }

    public class DrawImage {

        public void createImages() {
            imageList.add(createImage("Slot 1"));
            imageList.add(createImage("Slot 2"));
            imageList.add(createImage("Slot 3"));
            imageList.add(createImage("Slot 4"));
        }

        private BufferedImage createImage(String text) {
            Rectangle r = new Rectangle(0, 0, 200, 100);
            BufferedImage image = new BufferedImage(r.width, r.height,
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g = (Graphics2D) image.getGraphics();
            Font font = g.getFont();
            g.setFont(scale(font, g, text, image));
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            g.setColor(Color.YELLOW);
            centerString(g, r, text, font);
            g.dispose();

            return image;
        }

        private Font scale(Font f, Graphics g, String text, 
                BufferedImage img) {
            float ntry = 20.0f;
            Font font = null;

            while (2 < 3) {
                font = f.deriveFont(ntry);
                FontMetrics fm = g.getFontMetrics(font);
                int width = fm.stringWidth(text);
                if (width < img.getWidth()) {
                    return font;
                }
            }
        }

        /**
         * This method centers a <code>String</code> in
         * a bounding <code>Rectangle</code>.
         * @param g - The <code>Graphics</code> instance.
         * @param r - The bounding <code>Rectangle</code>.
         * @param s - The <code>String</code> to center in the
         * bounding rectangle.
         * @param font - The display font of the <code>String</code>
         *
         * @see java.awt.Graphics
         * @see java.awt.Rectangle
         * @see java.lang.String
         */
        private void centerString(Graphics g, Rectangle r, String s,
                Font font) {
            FontRenderContext frc =
                    new FontRenderContext(null, true, true);

            Rectangle2D r2D = font.getStringBounds(s, frc);
            int rWidth = (int) Math.round(r2D.getWidth());
            int rHeight = (int) Math.round(r2D.getHeight());
            int rX = (int) Math.round(r2D.getX());
            int rY = (int) Math.round(r2D.getY());

            int a = (r.width / 2) - (rWidth / 2) - rX;
            int b = (r.height / 2) - (rHeight / 2) - rY;

            g.setFont(font);
            g.drawString(s, r.x + a, r.y + b);
        }

    }

}