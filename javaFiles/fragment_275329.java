MouseAdapter mAdapter = new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        // Create the same transform as used for drawing the rectangle
        AffineTransform t = new AffineTransform();
        t.rotate(Math.toRadians(90), rect.x, rect.y);
        Point2D tp = t.inverseTransform(e.getPoint());

        if(rect.contains(tp)) {
            System.out.println("HIT INSIDE RECTANGLE");
        }
    }
};