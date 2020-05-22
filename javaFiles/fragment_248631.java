PlanarImage pi = PlanarImage.wrapRenderedImage(image);
        BufferedImage bi = pi.getAsBufferedImage();
        AffineTransform at = new AffineTransform();
            at.translate(-(image.getWidth() - image.getHeight()) / 2, (image.getWidth() - image.getHeight()) / 2);
            at.rotate(Math.toRadians(90),bi.getWidth()/2,bi.getHeight() / 2);
        AffineTransformOp opRotated = new AffineTransformOp(at,
                AffineTransformOp.TYPE_BILINEAR);
        image = opRotated.filter(bi, null);