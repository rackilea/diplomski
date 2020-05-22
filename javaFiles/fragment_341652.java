static BufferedImage deepCopy(BufferedImage bi) {
 ColorModel cm = bi.getColorModel();
 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
 WritableRaster raster = bi.copyData(null);
 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
}