import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/** @see http://stackoverflow.com/questions/2900801 */
public class Grid extends JPanel implements MouseMotionListener {

    private final BufferedImage img;
    private int imgW, imgH, paneW, paneH;

    public Grid(String name) {
        super(true);
        Icon icon = UIManager.getIcon(name);
        imgW = icon.getIconWidth();
        imgH = icon.getIconHeight();
        this.setPreferredSize(new Dimension(imgW * 10, imgH * 10));
        img = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        paneW = this.getWidth();
        paneH = this.getHeight();
        g.drawImage(img, 0, 0, paneW, paneH, null);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        int x = p.x * imgW / paneW;
        int y = p.y * imgH / paneH;
        int c = img.getRGB(x, y);
        this.setToolTipText(x + "," + y + ": "
            + String.format("%08X", c));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    private static void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Grid("Tree.closedIcon"));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }
}