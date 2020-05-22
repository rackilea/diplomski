public class HilbertCurveModel {

    private List<Point> points;
    private int distribution;

    private int xDelta, yDelta;

    public HilbertCurveModel(int level, int size) {
        points = new ArrayList<>(25);
        distribution = size;
        for (int i = level; i > 0; i--) {
            distribution /= 2;
        }
        hilbertU(level);
    }

    public int getDistribution() {
        return distribution;
    }

    public List<Point> getPoints() {
        List<Point> copy = new ArrayList<>(points.size());
        for (Point p : points) {
            copy.add(new Point(p));
        }
        return copy;
    }

    protected void addLine(int x, int y) {
        points.add(new Point(x + xDelta, y + yDelta));
        xDelta += x;
        yDelta += y;
    }

    private void hilbertU(int level) {
        if (level > 0) {
            hilbertD(level - 1);
            addLine(0, distribution);
            hilbertU(level - 1);
            addLine(distribution, 0);
            hilbertU(level - 1);
            addLine(0, -distribution);
            hilbertC(level - 1);
        }
    }

    private void hilbertD(int level) {
        if (level > 0) {
            hilbertU(level - 1);
            addLine(distribution, 0);
            hilbertD(level - 1);
            addLine(0, distribution);
            hilbertD(level - 1);
            addLine(-distribution, 0);
            hilbertA(level - 1);
        }
    }

    private void hilbertC(int level) {
        if (level > 0) {
            hilbertA(level - 1);
            addLine(-distribution, 0);
            hilbertC(level - 1);
            addLine(0, -distribution);
            hilbertC(level - 1);
            addLine(distribution, 0);
            hilbertU(level - 1);
        }
    }

    private void hilbertA(int level) {
        if (level > 0) {
            hilbertC(level - 1);
            addLine(0, -distribution);
            hilbertA(level - 1);
            addLine(-distribution, 0);
            hilbertA(level - 1);
            addLine(0, distribution);
            hilbertD(level - 1);
        }
    }

}