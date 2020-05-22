BufferedImage result = null;
Raster r = reader.readRaster()
if (r.getNumBands != 4){
    result = reader.read(0);
} else {

   if (isPhotoshopYCCK(reader)){
       result = YCCKtoCMYKtoRGB(r);
   }else{
      result = CMYKtoRGB(r);
   }
}

private boolean isPhotoshopYCCK(reader){
    // read IIOMetadata from reader and according to
    // http://download.oracle.com/javase/6/docs/api/javax/imageio/metadata/doc-files/jpeg_metadata.html decide which ColorSpace is used
    // or maybe there is another way to do it
    int transform = ... // 2 or 0 or something else
    return transform;
}