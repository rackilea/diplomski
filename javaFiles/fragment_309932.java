import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    JFrame frame;

    public Test() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final PaintPanel paintPanel = new PaintPanel();

        paintPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                paintPanel.addRect(e.getX(), e.getY());
            }
        });

        frame.setLayout(new FlowLayout());

        frame.add(paintPanel);
        frame.add(new JButton("Dummy"));

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }
}

class PaintPanel extends JPanel {

    public PaintPanel() {
        addRect(100, 100);
    }
    ArrayList<Rectangle> rects = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaintMode();

        for (Rectangle r : rects) {
            g2d.setStroke(new BasicStroke(1));
            g2d.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    public void addRect(int x, int y) {
        rects.add(new Rectangle(x, y, 10, 10));
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}