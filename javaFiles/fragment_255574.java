BufferedImage img = new BufferedImage(width, height,BufferedImage.TYPE_BYTE_GRAY);
WritableRaster raster = img.getRaster();
WritableRaster rasterJPEG = image.getRaster();

for(int h=0; h<height; h++)
   for(int w=0; w<width; w++) {
      int[] p = new int[4];
       rasterJPEG.getPixel(w, h, p);
       p[0] = (int) (0.3 * p[0]);
       p[1] = (int) (0.59 * p[1]);
       p[2] = (int) (0.11 * p[2]);
       int y = p[0] + p[1] + p[2];
       raster.setSample(w,h,0,y);
    }
 return img;