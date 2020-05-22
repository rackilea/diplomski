@Override
protected void paintComponent(Graphics g) {
    // Create a copy of the graphics context...
    Graphics2D graphics = (Graphics2D) g.create();
    // Don't rely on the frame, rely on your own components size...
    //Dimension dimension = frame.getSize();
    Insets insets = getInsets();
    int w = (int) ((getWidth() - insets.left - insets.right) / 2);
    int h = (int) ((getHeight() - insets.top - insets.bottom) / 2);
    graphics.translate(w, h);
    graphics.drawString("Origin", 0, 0);
    double y = 0;
    for (double x = -25; x <= 25; x += .01) {
        y = -Math.pow(x, 2);
        int gx = (int) x;
        int gy = (int) y;
        System.out.println("Parabola Coordinate: " + x + ", " + y);
        // You were using the "un-translated" reference, don't know if that was deliberate
        graphics.drawRect(gx, gy, 0, 0);
    }
    // Dispose of the copy and safe resources...
    graphics.dispose();
}