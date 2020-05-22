protected void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    Graphics2D g = (Graphics2D)gr; 

    // Create the original line, starting at the origin,
    // and extending along the x-axis
    Line2D line = new Line2D.Double(0,0,100,0);

    // Obtain an AffineTransform that describes a rotation
    // about a certain angle (given in radians!), around
    // the start point of the line. (Here, this is the
    // origin, so this could be simplified. But in this
    // form, it's more generic)
    AffineTransform at = 
        AffineTransform.getRotateInstance(
            Math.toRadians(angleInDegrees), line.getX1(), line.getY1());

    // Draw the rotated line
    g.draw(at.createTransformedShape(line));
}