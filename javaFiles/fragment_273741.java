public class Canvas extends JPanel {

    public static final int WIDTH = 600, HEIGHT = 500;

    public int x = WIDTH / 2;
    public int y = HEIGHT / 2;

    private List<Line> lines;

    public Canvas() {
        lines = new ArrayList<>(25);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    public void addPatt(Direction direction, int length) {
        lines.add(new Line(direction, length));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            switch (line.getDirection()) {
                case UP:
                    drawLineUp(g, line.getLength());
                    break;
                case DOWN:
                    drawLineDown(g, line.getLength());
                    break;
                case LEFT:
                    drawLineLeft(g, line.getLength());
                    break;
                case RIGHT:
                    drawLineDown(g, line.getLength());
                    break;
            }
        }
    }

    private void drawLineLeft(Graphics g, int pix) {

        if (pix > 0) {
            g.drawLine(x, y, x - 10 * pix, y);//left
            x = x - 10 * pix;
        }
    }

    private void drawLineUp(Graphics g, int pix) {

        if (pix > 0) {
            g.drawLine(x, y, x, y - 10 * pix);//up
            y = y - 10 * pix;
        }
    }

    private void drawLineRight(Graphics g, int pix) {
        if (pix > 0) {
            g.drawLine(x, y, x + 10 * pix, y);//right
            x = x + 10 * pix;
        }
    }

    private void drawLineDown(Graphics g, int pix) {
        if (pix > 0) {
            g.drawLine(x, y, x, y + 10 * pix);// down
            y = y + 10 * pix;
        }
    }

}