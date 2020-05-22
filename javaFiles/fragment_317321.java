// Create a field
private BufferedImage buffer;

// Call this when you need to change the polygon some how...
protected void createBuffer() {

    // You need to determine the width and height values ;)
    buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = image.createGraphics();

    int xoffset=5;//Multiply in order to "zoom" the picture
    int offset=0;//moves shape to the right

    p.addPoint(40*xoffset-offset, 30*xoffset-offset);
    p.addPoint(50*xoffset-offset,30*xoffset-offset);
    p.addPoint(57*xoffset-offset,37*xoffset-offset);
    p.addPoint(57*xoffset-offset,47*xoffset-offset);
    p.addPoint(50*xoffset-offset,54*xoffset-offset);
    p.addPoint(40*xoffset-offset,54*xoffset-offset);
    p.addPoint(33*xoffset-offset,47*xoffset-offset);
    p.addPoint(33*xoffset-offset, 37*xoffset-offset);

    g.drawPolygon(p);
    g.dispose();

}

protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (buffer != null) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(buffer, translateX, translateY, this);
    }
}