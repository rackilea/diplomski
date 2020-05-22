RenderingHints hints = new RenderingHints();
hints.put(RenderingHints.KEY_RENDERING,
          RenderingHints.VALUE_RENDER_SPEED);
hints.put(RenderingHints.KEY_INTERPOLATION,
          RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);

AffineTransform transform = AffineTransform.getScaleInstance(
    (double) newWidth / img.getWidth(),
    (double) newHeight / img.getHeight());
BufferedImageOp op = new AffineTransformOp(transform, hints);

BufferedImage scaledImage = op.filter(img, null);