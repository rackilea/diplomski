/** Emus Per Inch */
public static final int EPI = 914400;

image = new BufferedImage(pixelsWidth, pixelsHeight, BufferedImage.TYPE_INT_ARGB);
graphics = image.createGraphics();

AffineTransform scaleToEmus = AffineTransform.getScaleInstance((float)dpi / (float)IDrawingSurface.EPI, (float)dpi / (float)IDrawingSurface.EPI);
graphics.transform(scaleToEmus);