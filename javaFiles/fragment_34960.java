import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MouseScaleTest {

    public static void main(String[] args) {
        new MouseScaleTest();
    }

    public MouseScaleTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage img;

        private float scale = 1f;
        private float scaleDelta = 0.05f;

        public TestPane() {

            try {
                img = ImageIO.read(new File("/path/to/your/image"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            addMouseWheelListener(new MouseWheelListener() {

                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    int rotation = e.getWheelRotation();
                    if (rotation < 0) {
                        scale -= scaleDelta;
                    } else {
                        scale += scaleDelta;
                    }
                    if (scale < 0) {
                        scale = 0;
                    } else if (scale > 1) {
                        scale = 1;
                    }
                    repaint();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                int x = (int)((getWidth() - (img.getWidth() * scale)) / 2);
                int y = (int)(getHeight() - (img.getHeight() * scale)) / 2;

                AffineTransform at = new AffineTransform();
                at.translate(x, y);
                at.scale(scale, scale);

                g2d.setTransform(at);
                g2d.drawImage(img, 0, 0, this);

                g2d.dispose();
            }
        }
    }
}