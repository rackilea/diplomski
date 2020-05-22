private int currentPage = -1;
private Image cachedScaledImage = null;

public double getScaleFactor(int iMasterSize, int iTargetSize) {
    double dScale = 1;
    if (iMasterSize > iTargetSize) {
        dScale = (double) iTargetSize / (double) iMasterSize;
    } else {
        dScale = (double) iTargetSize / (double) iMasterSize;
    }
    return dScale;
}

public double getScaleFactorToFit(BufferedImage img, Dimension size) {
    double dScale = 1;
    if (img != null) {
        int imageWidth = img.getWidth();
        int imageHeight = img.getHeight();
        dScale = getScaleFactorToFit(new Dimension(imageWidth, imageHeight), size);
    }
    return dScale;
}

public double getScaleFactorToFit(Dimension original, Dimension toFit) {
    double dScale = 1d;
    if (original != null && toFit != null) {
        double dScaleWidth = getScaleFactor(original.width, toFit.width);
        double dScaleHeight = getScaleFactor(original.height, toFit.height);

        dScale = Math.min(dScaleHeight, dScaleWidth);
    }
    return dScale;
}

public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

    if (pageIndex >= images.size()) {
        return Printable.NO_SUCH_PAGE;
    }
    RenderedImage image;


    Graphics2D graphics2D = (Graphics2D) graphics;

    int width = (int)Math.round(pageFormat.getImageableWidth());
    int height = (int)Math.round(pageFormat.getImageableHeight());

    if (currentPage != pageIndex || cachedScaledImage == null) {
        currentPage = pageIndx;    

        image = new NullOpImage((RenderedImage) images.get(pageIndex), null, null, OpImage.OP_IO_BOUND);

        BufferedImage imageCopy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = imageCopy.createGraphics();
        g2d.drawImage(imageCopy, 0, 0, null);
        g2d.dispose();

        double scaleFactor = getScaleFactorToFit(new Dimension(image.getWidth(), image.getHeight()), new Dimension(width, height));

        int imageWidth = (int)Math.round(image.getWidth() * scaleFactor);
        int imageHeight = (int)Math.round(image.getHeight() * scaleFactor);

        double x = ((pageFormat.getImageableWidth() - imageWidth) / 2) + pageFormat.getImageableX();
        double y = ((pageFormat.getImageableHeight() - imageHeight) / 2) + pageFormat.getImageableY();

        cachedScaledImage = imageCopy.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

    }

    graphics2D.drawRenderedImage(cachedScaledImage, AffineTransform.getTranslateInstance(x, y));

    return PAGE_EXISTS;
}