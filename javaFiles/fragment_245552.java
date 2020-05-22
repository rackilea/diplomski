import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        public TestPane() {
            setLayout(new BorderLayout());
            BackgroundPane bgPane = new BackgroundPane();
            bgPane.setLayout(new GridBagLayout());
            add(bgPane);

            try {
                BufferedImage bg = ImageIO.read(new File("C:\\Users\\shane\\Dropbox\\MegaTokyo\\thumnails\\megatokyo_omnibus_1_3_cover_by_fredrin-d4oupef.jpg"));
                bgPane.setBackgroundImage(bg);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JLabel show = new JLabel("Bananas are yellow");
            show.setOpaque(true);
            show.setForeground(Color.RED);
            show.setBackground(Color.YELLOW);
            show.setBorder(new EmptyBorder(20, 20, 20, 20));
            bgPane.add(show);

        }

    }

    public class BackgroundPane extends JPanel {

        private BufferedImage img;

        @Override
        public Dimension getPreferredSize() {
            BufferedImage img = getBackgroundImage();

            Dimension size = super.getPreferredSize();
            if (img != null) {
                size.width = Math.max(size.width, img.getWidth());
                size.height = Math.max(size.height, img.getHeight());
            }

            return size;
        }

        public BufferedImage getBackgroundImage() {
            return img;
        }

        public void setBackgroundImage(BufferedImage value) {
            if (img != value) {
                BufferedImage old = img;
                img = value;
                firePropertyChange("background", old, img);
                revalidate();
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage bg = getBackgroundImage();
            if (bg != null) {
                int x = (getWidth() - bg.getWidth()) / 2;
                int y = (getHeight() - bg.getHeight()) / 2;
                g.drawImage(bg, x, y, this);
            }
        }

    }

}