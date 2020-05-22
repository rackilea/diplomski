public List<Point> getIntersects(Rectangle2D a, Rectangle2D b) {
        if (!a.intersects(b)) return null;
        List<Point> points = new ArrayList<Point>();
        double ax = a.getX();
        double ay = a.getY();
        double aw = a.getWidth();
        double ah = a.getHeight();
        double bx = b.getX();
        double by = b.getY();
        double bw = b.getWidth();
        double bh = b.getHeight();
        if (ax <= bx) {
            if (ay < by) {
                points.add(new Point((int) (ax + aw), (int) by));
                points.add(new Point((int) (bx), (int) (ay + ah)));
            } else {
                points.add(new Point((int) (ax + aw), (int) (by + bw)));
                points.add(new Point((int) (bx), (int) (ay)));
            }
        } else return getIntersects(b, a);
        return points;
    }