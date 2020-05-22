public void paint(Graphics g) {
    super.paint(g);
    for (Shape s: rectList )
        paintRect(g, s);
    //...
    //Add loops for all shapes
}

public void paintRect(Graphics g, Shape shape) {
    g.setColor(shape.color);
    g.fillRect(shape.x1, shape.y1, shape.x2, shape.y2);
}