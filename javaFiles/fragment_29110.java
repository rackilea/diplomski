import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CutExample {

    public static void main(String[] args) {
        new CutExample();
    }

    public CutExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;

        public TestPane() {
            try {
                img = ImageIO.read(...);
            } catch (IOException ex) {
                Logger.getLogger(CutExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (img != null) {
                int x = (getWidth() - img.getWidth()) / 2;
                int y = (getHeight() - img.getWidth()) / 2;
                g2d.drawImage(img, x, y, this);

                Area outter = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
                x = (getWidth() / 2) - 100;
                y = (getHeight() / 2) - 100;
                Rectangle inner = new Rectangle(x, y, 200, 200);
                outter.subtract(new Area(inner));

                g2d.setColor(new Color(0, 0, 0, 192));
                g2d.fill(outter);
            }
            g2d.dispose();
        }

    }

}