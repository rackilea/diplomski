QuantizeFilter q = new QuantizeFilter();
int [] inPixels = new int[image.getWidth()*image.getHeight()*3];
int [] outPixels = new int[image.getWidth()*image.getHeight()*3];
image.getRaster().getPixels( 0, 0, image.getWidth(), image.getHeight(), inPixels );
q.quantize(inPixels, outPixels, image.getWidth(), image.getHeight(), 64, false, false);
WritableRaster raster = (WritableRaster) image.getData();
raster.setPixels(0,0,width,height,outPixels);