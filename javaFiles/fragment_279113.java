@Override
protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;

    // empty component (no image)

    if ( source == null ) {
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        return;
    }

    // account for borders
    Insets insets = getInsets();
    int tx = insets.left + originX;
    int ty = insets.top  + originY;

    // clear damaged component area
    Rectangle clipBounds = g2d.getClipBounds();
    g2d.setColor(getBackground());
    g2d.fillRect(clipBounds.x,
                 clipBounds.y,
                 clipBounds.width,
                 clipBounds.height);

    /**

        Translation moves the entire image within the container

    */
    affineTrans = new AffineTransform();
    affineTrans.setTransform( AffineTransform.getTranslateInstance(tx, ty) );
    if ( (sx != 0) && (sy != 0) )
       affineTrans.scale(sx, sy);

    g2d.drawRenderedImage(source, affineTrans);
}