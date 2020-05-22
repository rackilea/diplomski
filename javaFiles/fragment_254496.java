public void mouseDragged(MouseEvent e) {

    Point newPoint = new Point(e.getX(), e.getY());
    int xStart = oldPoint.x;
    int yStart = oldPointy;
    int width = newPoint.x - xStart;
    int height = newPoint.y - yStart;

    if (width < 0) {
        width = -width;
        xStart -= width;
    }
    if (height < 0) {
        height = -height;
        yStart -= height;
    }

    if (shape.equals("1")) {
        image = cloneImage(originalImage);
        drawCir(xStart, yStart, width, height);
        repaint();
    }
    ...etc...