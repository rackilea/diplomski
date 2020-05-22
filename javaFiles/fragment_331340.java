class Circle2 {
    private Color color;
    private Path2D path; // easily moveable with affine transform

    public Circle2(int centerX, int centerY, int radius, Color color) {
        this.color = color;
        double x = centerX - radius;
        double y = centerY - radius;
        double w = 2 * radius;
        double h = w;
        Ellipse2D e2d = new Ellipse2D.Double(x, y, w, h);
        path = new Path2D.Double(e2d);
    }    

    public void move(Point p0, Point p1) {
        // get the distance or "delta" of the move
        int deltaX = p1.x - p0.x;
        int deltaY = p1.y - p0.y;

        // move the circle delta amount
        path.transform(AffineTransform.getTranslateInstance(deltaX, deltaY));
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(path);
        g2.setColor(Color.BLACK);
        g2.draw(path);
    }

    public int getCenterX() {
        return (int) path.getBounds().getCenterX();
    }

    public int getCenterY() {
        return (int) path.getBounds().getCenterY();
    }

    public int getRadius() {
        return (int) path.getBounds().getWidth() / 2;
    }

    public Color getColor() {
        return color;
    }

    public Shape getEllipse() {
        return path;
    }  

    public boolean contains(Point p) {
        return path.contains(p);
    }

}