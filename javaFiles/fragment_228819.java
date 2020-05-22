BufferedImage scaledImage = new BufferedImage(
    scaledWidth,
    scaledHeight,
    BufferedImage.TYPE_INT_RGB
);

Graphics2D g = scaledImage.createGraphics();
g.setRenderingHints(
    RenderingHints.Key.KEY_INTERPOLATION,
    RenderingHints.VALUE_INTERPOLATION_BICUBIC
);

g.drawImage(panelImage, 0, 0, scaledWidth, scaledHeight, null);
g.dispose();