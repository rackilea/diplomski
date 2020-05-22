import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestTransparentFrame extends JLabel {

    private boolean drawing = false;
    private Point lastPoint;

    private BufferedImage image;

    public TestTransparentFrame() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateImage();
            }
        });
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawing = true;
                lastPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
                lastPoint = null;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                drawing = false;
                lastPoint = null;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (drawing && lastPoint != null) {
                    Graphics graphics = image.getGraphics();
                    graphics.setColor(Color.RED);
                    ((Graphics2D) graphics).setStroke(new BasicStroke(5.0f));
                    graphics.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                    repaint();
                    lastPoint = e.getPoint();
                }
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    protected void updateImage() {
        if (image == null || image.getWidth() < getWidth() || image.getHeight() < getHeight()) {
            if (image == null) {
                image = getGraphicsConfiguration().createCompatibleImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            } else {
                BufferedImage newImage = getGraphicsConfiguration().createCompatibleImage(getWidth(), getHeight(),
                        BufferedImage.TYPE_INT_ARGB);
                newImage.getGraphics().drawImage(image, 0, 0, null);
                image = newImage;
            }
        } else {
            image = image.getSubimage(0, 0, getWidth(), getHeight());
        }
        setIcon(new ImageIcon(image));
    }

    protected void initUI() {
        JFrame frame = new JFrame(TestTransparentFrame.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setBackground(new Color(255, 255, 255, 1));
        TestTransparentFrame comp = new TestTransparentFrame();
        frame.setContentPane(comp);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTransparentFrame().initUI();
            }
        });
    }

}