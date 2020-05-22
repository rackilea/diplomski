byte[] aByteArray = {0xa,0x2,0xf,(byte)0xff,(byte)0xff,(byte)0xff};
int width = 1;
int height = 2;

DataBuffer buffer = new DataBufferByte(aByteArray, aByteArray.length);

//3 bytes per pixel: red, green, blue
WritableRaster raster = Raster.createInterleavedRaster(buffer, width, height, 3 * width, 3, new int[] {0, 1, 2}, (Point)null);
ColorModel cm = new ComponentColorModel(ColorModel.getRGBdefault().getColorSpace(), false, true, Transparency.OPAQUE, DataBuffer.TYPE_BYTE); 
BufferedImage image = new BufferedImage(cm, raster, true, null);

ImageIO.write(image, "png", new File("image.png"));