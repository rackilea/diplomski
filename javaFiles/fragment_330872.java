public class SierpinskiGasket extends JFrame {

    public static void main(String[] args) {    
        new SierpinskiGasket();
    }

    // Class constructor
    public SierpinskiGasket() {
        Container c = getContentPane();
        JPanel jp = new JPanel();
        jp.setBackground(Color.white);
        c.add(jp);
        setTitle("Sierpinski Gasket");
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Random rndm = new Random();

        Point pt0 = new Point(200, 50);
        Point pt1 = new Point(350, 350);
        Point pt2 = new Point(50, 350);
        Point current = pt0;

        g.setColor(Color.RED);

        drawPoint(g, pt0);
        drawPoint(g, pt1);
        drawPoint(g, pt2);

        Point[] pts = { pt0,pt1,pt2 };
        for (int i = 0 ; i < 10000 ; i++) {
            current = midpoint(current, pts[rndm.nextInt(3)]);
            drawPoint(g, current);
        }
    }

    private static void drawPoint(Graphics g, Point p) {
        g.drawLine(p.x, p.y, p.x, p.y);
    }

    /**
     * Calculates the midpoint between the two points
     * 
     * @param c
     * @param t
     * @return The midpoint
     */
    public Point midpoint(Point c, Point t) {    
        return new Point((Math.round((c.x + t.x) / 2)),
                Math.round(((c.y + t.y) / 2)));     
    }
}