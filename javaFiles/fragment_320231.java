Graphics2D g2 = (Graphics2D)g;
    int newW = (int)(originalImage.getWidth() * xScaleFactor);
    int newH = (int)(originalImage.getHeight() * yScaleFactor);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    g2.drawImage(originalImage, 0, 0, newW, newH, null);