private static final String CLASS_NAME = ThumbnailUtils.class.getSimpleName();

private final Color BKGROUND_COLOR = Color.WHITE;
private boolean imageLoaded = false;

public void writeThumbnail(String originalImagePath, int thumbWidth, int thumbHeight, String thumbImagePath)
        throws Exception {

    InputStream originalImageStream = new FileInputStream(originalImagePath);
    File fileOut = new File(thumbImagePath);
    if (fileOut.exists()) {
        fileOut.delete();
    }
    OutputStream thumbImageOutStream = new FileOutputStream(fileOut);
    writeThumbnail(originalImageStream, thumbWidth, thumbHeight, thumbImageOutStream);
    thumbImageOutStream.close();
    originalImageStream.close();
}

public void writeThumbnail(File file, int thumbWidth, int thumbHeight, String thumbImagePath) throws Exception {

    InputStream originalImageStream = new FileInputStream(file);
    File fileOut = new File(thumbImagePath);
    if (fileOut.exists()) {
        fileOut.delete();
    }
    OutputStream thumbImageOutStream = new FileOutputStream(fileOut);

    writeThumbnail(originalImageStream, thumbWidth, thumbHeight, thumbImageOutStream);

    thumbImageOutStream.close();
    originalImageStream.close();

}

private void writeThumbnail(InputStream originalImageStream, int thumbWidth, int thumbHeight,
        OutputStream thumbImageOutStream) throws Exception {

    ByteArrayOutputStream byteArrOutputStream = null;
    try {
        byteArrOutputStream = makeThumbnail(originalImageStream, thumbWidth, thumbHeight);
        byteArrOutputStream.writeTo(thumbImageOutStream);
        byteArrOutputStream.flush();
    } finally {
        if (byteArrOutputStream != null) {
            byteArrOutputStream.close();
        }
    }

}

private Image makeThumbnail(final Image originalImage, final int maxWidth, final int maxHeight) throws Exception {
    // ImageOveserve is ingnored for BufferedImages
    final int photoWidth = originalImage.getWidth(null);
    final int photoHeight = originalImage.getHeight(null);

    int thumbWidth = maxWidth;
    int thumbHeight = maxHeight;
    final double thumbRatio = (double) thumbWidth / (double) thumbHeight;
    final double photoRatio = (double) photoWidth / (double) photoHeight;

    if (thumbRatio < photoRatio)
        thumbHeight = (int) (thumbWidth / photoRatio);
    else
        thumbWidth = (int) (thumbHeight * photoRatio);

    // Checking if the photo's size is smaller than thumbnail's size: getting the original size
    if (photoWidth < thumbWidth) {
        thumbWidth = photoWidth;
    }
    if (photoHeight < thumbHeight) {
        thumbHeight = photoHeight;
    }

    final BufferedImage thumbnailBufferedImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);
    final Graphics2D graphics2D = thumbnailBufferedImage.createGraphics();

    // Best Quality Render Hints!
    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
            RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);

    final AffineTransform t = new AffineTransform();
    t.scale((double) thumbWidth / photoWidth, (double) thumbHeight / photoHeight);

    graphics2D.setBackground(BKGROUND_COLOR);
    final boolean complete = graphics2D.drawImage(originalImage, t, this);

    if (!complete) {
        while (!imageLoaded) {
            try {
                wait(100);
            } catch (InterruptedException ie) {
            }
        }
    }

    graphics2D.dispose();

    return thumbnailBufferedImage;
}

private synchronized ByteArrayOutputStream makeThumbnail(final InputStream originalImageStream, final int maxWidth,
        final int maxHeight) throws Exception {

    SeekableStream seekableStream = SeekableStream.wrapInputStream(originalImageStream, true);
    RenderedOp reop = JAI.create("stream", seekableStream);
    Image photo = reop.getAsBufferedImage();

    final BufferedImage thumbnail = (BufferedImage) makeThumbnail(photo, maxWidth, maxHeight);

    final ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
    ImageIO.write(thumbnail, GlobalResourceUtils.getFileExtension(), byteArrayStream);

    return byteArrayStream;
}

@Override
public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
    if (infoflags != ALLBITS) {
        // Image has not finished loading!
        // Return true to tell the image loading thread to keep drawing until image fully loads.
        return true;
    } else {
        imageLoaded = true;
        return false;
    }
}