@Override
protected void paintComponent(final Graphics g) {
    final Graphics2D graphics2D = (Graphics2D) g;
    RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    graphics2D.setRenderingHints(qualityHints);
    graphics2D.setPaint(new Color(80, 150, 180));
    int width = getWidth();
    int height = getHeight();
    GeneralPath path = new GeneralPath();
    path.moveTo(5, 10);
    path.curveTo(5, 10, 7, 5, 0, 0);
    path.curveTo(0, 0, 12, 0, 12, 5);
    path.curveTo(12, 5, 12, 0, 20, 0);
    path.lineTo(width - 10, 0);
    path.curveTo(width - 10, 0, width, 0, width, 10);
    path.lineTo(width, height - 10);
    path.curveTo(width, height - 10, width, height, width - 10, height);
    path.lineTo(15, height);
    path.curveTo(15, height, 5, height, 5, height - 10);
    path.lineTo(5, 15);
    path.closePath();
    graphics2D.fill(path);
}