DataBufferDouble dbd = new DataBufferDouble(destWidth * destHeight * 4);

SampleModel sm = new PixelInterleavedSampleModel(DataBuffer.TYPE_DOUBLE, destWidth, destHeight, 4, destWidth * 4, new int[] {2, 1, 0, 3});

WritableRaster wr = WritableRaster.createWritableRaster(sm, dbd, null);

ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_LINEAR_RGB), true, true, ColorModel.TRANSLUCENT, DataBuffer.TYPE_FLOAT);

BufferedImage bi = new BufferedImage(cm, wr, true, new Hashtable<Object, Object>());