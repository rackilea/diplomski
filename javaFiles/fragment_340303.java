BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
Graphics2D g = resizedImage.createGraphics();
g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
g.dispose();
g.setComposite(AlphaComposite.Src);
g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);