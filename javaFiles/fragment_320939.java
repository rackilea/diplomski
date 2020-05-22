@Override
protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    String label = getLabel();
    if (label != null && (getText() == null || getText().length() == 0)) {

        Insets insets = getInsets();
        int width = getWidth() - (insets.left + insets.right);
        int height = getHeight() - (insets.top + insets.bottom);

        // This buffer should be created when the label is changed
        // or the size of the component is changed...
        BufferedImage buffer = ImageUtilities.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        Graphics2D g2d = buffer.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getForeground());
        g2d.setFont(getFont());

        FontMetrics fm = g2d.getFontMetrics();

        Composite comp = g2d.getComposite();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f));

        int textHeight = fm.getHeight();

        int x = insets.left;
        int y = ((height - textHeight) / 2) + fm.getAscent();

        g2d.drawString(label, 0, y);

        g2d.dispose();

        g.drawImage(buffer, insets.left, insets.top, this);

    }

}