static void activateAntiAliasing(Graphics g) {
    try {
        Graphics2D g2d = (Graphics2D)g;

        // for antialiasing geometric shapes
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                              RenderingHints.VALUE_ANTIALIAS_ON );

        // for antialiasing text
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                              RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

        // to go for quality over speed
        g2d.setRenderingHint( RenderingHints.KEY_RENDERING,
                              RenderingHints.VALUE_RENDER_QUALITY );
    }
    catch(ClassCastException ignored) {}
}

@Override public void paint(final Graphics g) {
    activateAntiAliasing(g);
    super.paint(g);
}