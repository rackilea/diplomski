public class Graph extends JPanel {

    private static int gridSize = 6;
    private static int scale = 100;
    private static int size = gridSize * scale;
    private static int translate = size / 2;
    private static int pointSize = 10;

    List<Point> dataPoints, scaledPoints;

    Graph() {
        setBackground(Color.WHITE);

        // points taken from your example
        Point p1 = new Point(-1, -2);
        Point p2 = new Point(-1, 0);
        Point p3 = new Point(1, 0);
        Point p4 = new Point(1, -2);
        dataPoints = Arrays.asList(p1, p2, p3, p4);

        scaledPoints = dataPoints.stream()
                .map(p -> new Point(p.x * scale + translate, -p.y * scale + translate))
                .collect(Collectors.toList());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // draw a grid
        for (int i = 0; i < gridSize; i++) {
            g2d.drawLine(i * scale, 0, i * scale, size);
            g2d.drawLine(0, i * scale, size, i * scale);
        }

        // draw the rectangle
        g2d.setPaint(Color.RED);
        g2d.drawPolygon(scaledPoints.stream().mapToInt(p -> p.x).toArray(),
                        scaledPoints.stream().mapToInt(p -> p.y).toArray(),
                        scaledPoints.size());

        // draw the points
        g2d.setPaint(Color.BLUE);
        // origin
        g2d.fillRect(translate, translate, pointSize, pointSize);
        g2d.drawString("(0, 0)", translate, translate);
        // data
        for (int i = 0; i < dataPoints.size(); i++) {
            Point sp = scaledPoints.get(i);
            Point dp = dataPoints.get(i);
            g2d.fillRect(sp.x, sp.y, pointSize, pointSize);
            g2d.drawString("(" + dp.x + ", " + dp.y + ")", sp.x, sp.y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Graph());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}