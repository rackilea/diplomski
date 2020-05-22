int[] nBits = {8, 8, 8};
ComponentSampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, width, height, channels, width * channels, new int[] {2, 1, 0});
ColorSpace colorSpace = ColorSpace.getInstance(ColorSpace.CS_sRGB);
ColorModel colorModel = new ComponentColorModel(colorSpace, nBits, false, false,Transparency.OPAQUE,DataBuffer.TYPE_BYTE);

DataBufferByte db = new DataBufferByte(new byte[][] {buffer}, buffer.length);

WritableRaster raster = Raster.createWritableRaster(sampleModel, db, new Point(0, 0));
BufferedImage image = new BufferedImage(colorModel, raster, false, null);