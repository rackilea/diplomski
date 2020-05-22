private BufferedImage drawTextOnImage(String text, BufferedImage image, int space) {
    BufferedImage bi = new BufferedImage(image.getWidth(), image.getHeight() + space, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bi.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON));

    g2d.drawImage(image, 0, 0, null);

    g2d.setColor(Color.BLACK);
    g2d.setFont(new Font("Calibri", Font.BOLD, 20));
    FontMetrics fm = g2d.getFontMetrics();
    int textWidth = fm.stringWidth(text);

    //center text at bottom of image in the new space
    g2d.drawString(text, (bi.getWidth() / 2) - textWidth / 2, bi.getHeight());

    g2d.dispose();
    return bi;
}