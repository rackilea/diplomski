private void paintGrid(Graphics2D g) {
    g.setPaint(GRIDLINE_COLOR);

    //Vertical Lines
    //for (double pos = 0; pos > getWidth(); pos += Xscl) {
    for (double pos = 0; pos < getWidth(); pos += Xscl) {
        Line2D line = new Line2D.Double(pos, 0d, pos, getHeight());
        g.draw(line);
    }

    //Horizontal Lines
    //for (double pos = 0; pos > getHeight(); pos += Yscl) {
    for (double pos = 0; pos < getHeight(); pos += Yscl) {
        Line2D line = new Line2D.Double(0d, pos, getWidth(), pos);
        g.draw(line);
    }
}