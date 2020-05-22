public class RoundTop extends JPanel {

    //Polygons declarations
    private Polygon p = new Polygon();
    //Translate variables;
    private int translateX = 10;
    private int translateY = 10;

    public RoundTop() {

        int xoffset = 5;//Multiply in order to "zoom" the picture
        int offset = 0;//moves shape to the right

        p.addPoint(40 * xoffset - offset, 30 * xoffset - offset);
        p.addPoint(50 * xoffset - offset, 30 * xoffset - offset);
        p.addPoint(57 * xoffset - offset, 37 * xoffset - offset);
        p.addPoint(57 * xoffset - offset, 47 * xoffset - offset);
        p.addPoint(50 * xoffset - offset, 54 * xoffset - offset);
        p.addPoint(40 * xoffset - offset, 54 * xoffset - offset);
        p.addPoint(33 * xoffset - offset, 47 * xoffset - offset);
        p.addPoint(33 * xoffset - offset, 37 * xoffset - offset);

        p.translate(translateX, translateY);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.drawPolygon(p);

        g2d.dispose();

    }
}