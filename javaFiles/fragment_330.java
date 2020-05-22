import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample extends JFrame implements MouseListener, MouseMotionListener {

    JPanel MainPane;
    Container contentPane;
    ArrayList<Ellipse2D> redEl = new ArrayList<Ellipse2D>();
    ArrayList<Ellipse2D> whiteEl = new ArrayList<Ellipse2D>();
    Ellipse2D el1 = new Ellipse2D.Double(120, 110, 50, 50);
    Ellipse2D el2 = new Ellipse2D.Double(250, 110, 50, 50);
    Ellipse2D el3 = new Ellipse2D.Double(390, 110, 50, 50);
    Ellipse2D el4 = new Ellipse2D.Double(540, 110, 50, 50);
    Ellipse2D el5 = new Ellipse2D.Double(120, 390, 50, 50);
    Ellipse2D el6 = new Ellipse2D.Double(250, 390, 50, 50);
    Ellipse2D el7 = new Ellipse2D.Double(390, 390, 50, 50);
    Ellipse2D el8 = new Ellipse2D.Double(540, 390, 50, 50);
    int x;
    int y;
    private Point2D.Double offSet;

    public Sample() {

        redEl.add(el1);
        redEl.add(el2);
        redEl.add(el3);
        redEl.add(el4);
        whiteEl.add(el5);
        whiteEl.add(el6);
        whiteEl.add(el7);
        whiteEl.add(el8);

        MainPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                for (Shape red : redEl) {
                    g2.setColor(Color.RED);
                    g2.fill(red);
                    g2.draw(red);
                }

                for (Shape white : whiteEl) {
                    g2.setColor(Color.WHITE);
                    g2.fill(white);
                    g2.draw(white);
                }
            }
        };

        MainPane.setBackground(Color.BLACK);
        contentPane = this.getContentPane();
        contentPane.add(MainPane);
        MainPane.setLayout(null);

        setVisible(true);
        setSize(701, 701);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPane.addMouseListener(this);
        MainPane.addMouseMotionListener(this);
    }

    private Ellipse2D selected = null;

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        List<Ellipse2D> all = new ArrayList<>(redEl);
        all.addAll(whiteEl);
        for (Ellipse2D el : all) {
            if (el.contains(x, y)) {
                selected = el;
                offSet = new Point2D.Double(x - el.getX(), y - el.getY());
                break;
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        selected = null;
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {

        if (selected != null) {

            double x = e.getX() - offSet.x;
            double y = e.getY() - offSet.y;

            Rectangle2D bounds = selected.getBounds2D();
            bounds.setFrame(new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight()));

            selected.setFrame(bounds);
            repaint();

        }
    }

    public void mouseMoved(MouseEvent e) {
    }

    public static void main(String args[]) {
        new Sample();
    }

}