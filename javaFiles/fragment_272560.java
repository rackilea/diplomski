int imageWidth = 638, imageHeight = 480;
int dataImageWidth = 640;

SampleModel sm = new SinglePixelPackedSampleModel(TYPE_INT, imageWidth, imageHeight, dataImageWidth, new int[] { 0xff0000, 0xff00, 0xff });
DataBuffer db = new DataBufferInt(dataImageWidth * imageHeight);
WritableRaster r = Raster.createWritableRaster(sm, db, new Point());
BufferedImage image = new BufferedImage(ColorModel.getRGBDefault(), r, false, null);