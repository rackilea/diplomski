private Node findNearestNode(ObservableList<Node> nodes, double x, double y) {
    Point2D pClick = new Point2D(x, y);
    Node nearestNode = null;
    double closestDistance = Double.POSITIVE_INFINITY;

    for (Node node : nodes) {
        Bounds bounds = node.getBoundsInParent();
        Point2D[] corners = new Point2D[] {
                new Point2D(bounds.getMinX(), bounds.getMinY()),
                new Point2D(bounds.getMaxX(), bounds.getMinY()),
                new Point2D(bounds.getMaxX(), bounds.getMaxY()),
                new Point2D(bounds.getMinX(), bounds.getMaxY()),
        };

        for (Point2D pCompare: corners) {
            double nextDist = pClick.distance(pCompare);
            if (nextDist < closestDistance) {
                closestDistance = nextDist;
                nearestNode = node;
            }
        }
    }

    return nearestNode;
}