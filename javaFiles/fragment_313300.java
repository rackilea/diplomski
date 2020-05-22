Shape shape = null;
switch (whichShape) {
    case 0:
        shape = new Line2D.Double(x, y, x + width, y + height);
        break;
    case 1:
        shape = new Rectangle2D.Double(x, y, width, height);
        break;
    case 2:
        shape = new Ellipse2D.Double(x, y, width, height);
        break;
}