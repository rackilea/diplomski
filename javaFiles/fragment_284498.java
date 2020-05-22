import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class Square extends JPanel implements MouseListener,
        MouseMotionListener {

    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame f = new JFrame("Cube Rotational");
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    Square square = new Square();
                    square.setBorder(new EmptyBorder(5,5,5,5));
                    f.setContentPane(square);
                    f.pack();
                    f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Square() {
        init();
        setPreferredSize(new Dimension(700,700));
    }

    class Point3D {
        public int x, y, z;

        public Point3D(int X, int Y, int Z) {
            x = X;
            y = Y;
            z = Z;
        }
    }

    class Edge {
        public int a, b;

        public Edge(int A, int B) {
            a = A;
            b = B;
        }
    }

    static int width, height;
    static int mx, my;

    static int azimuth = 45, elevation = 45;

    static Point3D[] vertices;
    static Edge[] edges;

    public void init() {

        width = 500;
        height = 500;

        vertices = new Point3D[8];
        vertices[0] = new Point3D(-1, -1, -1);
        vertices[1] = new Point3D(-1, -1, 1);
        vertices[2] = new Point3D(-1, 1, -1);
        vertices[3] = new Point3D(-1, 1, 1);
        vertices[4] = new Point3D(1, 1, -1);
        vertices[5] = new Point3D(1, 1, 1);
        vertices[6] = new Point3D(1, -1, -1);
        vertices[7] = new Point3D(1, -1, 1);
        edges = new Edge[12];
        edges[0] = new Edge(0, 1);
        edges[1] = new Edge(0, 2);
        edges[2] = new Edge(0, 6);
        edges[3] = new Edge(1, 3);
        edges[4] = new Edge(1, 7);
        edges[5] = new Edge(2, 3);
        edges[6] = new Edge(2, 4);
        edges[7] = new Edge(3, 5);
        edges[8] = new Edge(4, 5);
        edges[9] = new Edge(4, 6);
        edges[10] = new Edge(5, 7);
        edges[11] = new Edge(6, 7);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    void drawWireframe(Graphics g) {
        double theta = Math.PI * azimuth / 180.0;
        double phi = Math.PI * elevation / 180.0;
        float cosT = (float) Math.cos(theta);
        float sinT = (float) Math.sin(theta);
        float cosP = (float) Math.cos(phi);
        float sinP = (float) Math.sin(phi);
        float cosTcosP = cosT * cosP;
        float cosTsinP = cosT * sinP;
        float sinTcosP = sinT * cosP;
        float sinTsinP = sinT * sinP;
        Point[] points;
        points = new Point[vertices.length];
        float scaleFactor = (getWidth() + getHeight()) / 8;
        float near = (float) 6;
        float nearToObj = 1.5f;
        for (int j = 0; j < vertices.length; ++j) {
            int x0 = vertices[j].x;
            int y0 = vertices[j].y;
            int z0 = vertices[j].z;
            float x1 = cosT * x0 + sinT * z0;
            float y1 = -sinTsinP * x0 + cosP * y0 + cosTsinP * z0;
            float z1 = cosTcosP * z0 - sinTcosP * x0 - sinP * y0;
            x1 = x1 * near / (z1 + near + nearToObj);
            y1 = y1 * near / (z1 + near + nearToObj);
            points[j] = new Point(
                    (int) (getWidth() / 2 + scaleFactor * x1 + 0.5),
                    (int) (getHeight() / 2 - scaleFactor * y1 + 0.5));
        }
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        for (int j = 0; j < edges.length; ++j) {
            int x1 = points[edges[j].a].x;
            int x2 = points[edges[j].b].x;
            int y1 = points[edges[j].a].y;
            int y2 = points[edges[j].b].y;
            ((Graphics2D) g).setStroke(new BasicStroke(5));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        e.consume();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        int new_mx = e.getX();
        int new_my = e.getY();
        azimuth -= new_mx - mx;
        azimuth %= 360;
        elevation += new_my - my;
        elevation %= 360;
        repaint();
        mx = new_mx;
        my = new_my;

        repaint();
        e.consume();
    }

    @Override
    public void paintComponent(Graphics g) {
        drawWireframe(g);
    }
}