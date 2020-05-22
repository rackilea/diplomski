BufferedImage scaledImage = new BufferedImage(
    img.getColorModel(),
    img.getRaster().createCompatibleWritableRaster(newWidth, newHeight),
    false, new Properties());

Graphics g = scaledImage.createGraphics();
g.setRenderingHint(RenderingHints.KEY_RENDERING,
                   RenderingHints.VALUE_RENDER_SPEED);
g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                   RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

g.drawImage(img, 0, 0, newWidth, newHeight, null);
g.dispose();