protected  void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    Insets insets = getInsets();
    // int w = getWidth() - insets.left - insets.right;
    int h = getHeight() - insets.top - insets.bottom;

    AffineTransform oldAT = g2.getTransform();
    try {
        //Move the origin to bottom-left, flip y axis
        g2.scale(1.0, -1.0);
        g2.translate(0, -h - insets.top);

        int xpoints[] = { 20, 30, 30, 35, 25, 15, 20 };
        int ypoints[] = { 10, 10, 30, 30, 45, 30, 30 };
        int npoints = 7;
        g2.fillPolygon(xpoints, ypoints, npoints);
    }
    finally {
      //restore
      g2.setTransform(oldAT);
    }
}