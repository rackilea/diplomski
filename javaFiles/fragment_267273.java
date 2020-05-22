enum Axis {
    X, Y;

    public Axis next() {
        return values()[(ordinal() + 1) % values().length];
    }
}

interface Node {
    Point closestTo(Point point);
}

class Leaf implements Node {
    private final Point point;

    public Leaf(Point point) {
        this.point = point;
    }

    public Point closestTo(Point point) {
        return this.point;
    }
}

class Branch implements Node {
    private final Axis axis;
    private final Point median;
    private final Node smaller;
    private final Node larger;

    public Branch(Axis axis, Point median, Node smaller, Node larger) {
        this.axis = axis;
        this.median = median;
        this.smaller = smaller;
        this.larger = larger;
    }

    public Point closestTo(Point point) {
        ...
    }
}

class KD_Tree {
    private final Optional<Node> root;

    public KD_Tree(List<Point> points) {
        this.root = makeNode(points);
    }

    private Optional<Node> makeNode(Axis axis, List<Point> points) {
        switch (points.size()) {
            case 0: 
                return Optional.empty();
            case 1: 
                return Optional.of(new Leaf(points.get(0));
            default:
                Point median = medianOf(points);
                Node smaller = makeNode(axis.next(), lessThan(median, points)).get();
                Node larger = makeNode(axis.next(), greaterThan(median, points)).get();
                return Optional.of(new Branch(axis, median, smaller, larger));
        }
    }
}