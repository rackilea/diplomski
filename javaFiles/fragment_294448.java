private void drawString(String text, int x, int y, Graphics2D g, Color bg){    
    // Prepare an off-screen image to draw the string to
    Rectangle2D bounds = g.getFontMetrics().getStringBounds(text, g);
    BufferedImage image = configuration.createCompatibleImage(
                              (int)(bounds.getWidth() + 1.0f), 
                              (int)(bounds.getHeight() + 1.0f),
                              Transparency.OPAQUE);
    Graphics2D ig = image.createGraphics();

    // Fill the background color
    ig.setColor(bg);
    ig.fillRect(0, 0, image.getWidth(), image.getHeight());

    // Draw the string
    int x0 = 0;
    int y0 = ig.getFontMetrics().getAscent();
    ig.setColor(g.getColor());
    ig.setRenderingHints(g.getRenderingHints());
    ig.setFont(g.getFont());
    ig.drawString(text, x0, y0);
    ig.dispose();

    // Blit the image to the destination
    g.drawImage(image, x-x0, y-y0, null);
}