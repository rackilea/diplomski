public static void main(String[] args) throws Exception {
    // Look at the following line: diamond operator and new.
    Set<Point> points = new TreeSet<>(new PointComparator());
}

static class PointComparator implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        if (!p1.equals(p2)) {
            return -1;
        }
        return 0;
    }
}