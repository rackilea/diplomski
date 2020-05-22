import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see https://stackoverflow.com/a/5312702/230513 */
public class MouseDragTest extends JPanel {

    private static final String TITLE = "Drag me!";
    private static final Random r = new Random();
    private static final int W = 640;
    private static final int H = 480;
    private Point textPt = new Point(W / 2, H / 2);
    private Point mousePt;
    private Color color = Color.black;

    public MouseDragTest() {
        this.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 32));
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                mousePt = e.getPoint();
                setColor(Color.getHSBColor(r.nextFloat(), 1, 1));
                repaint();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX() - mousePt.x;
                int dy = e.getY() - mousePt.y;
                textPt.setLocation(textPt.x + dx, textPt.y + dy);
                mousePt = e.getPoint();
                repaint();
            }
        });
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(W, H);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        int w2 = g.getFontMetrics().stringWidth(TITLE) / 2;
        g.drawString(TITLE, textPt.x - w2, textPt.y);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame(TITLE);
                f.add(new MouseDragTest());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}