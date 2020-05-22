private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
private static final ColorModel RGB_OPAQUE =
    new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);

    // ...

String sUrl="http://img01.taobaocdn.com/imgextra/i1/449400070/T2hbVwXj0XXXXXXXXX_!!449400070.jpg";
URL url = new URL(sUrl);
Image img = Toolkit.getDefaultToolkit().createImage(url);

PixelGrabber pg = new PixelGrabber(img, 0, 0, -1, -1, true);
pg.grabPixels();
int width = pg.getWidth(), height = pg.getHeight();

DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
BufferedImage bi = new BufferedImage(RGB_OPAQUE, raster, false, null);

String to = "D:/temp/result.jpg";
ImageIO.write(bi, "jpg", new File(to));