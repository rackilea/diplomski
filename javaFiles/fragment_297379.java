// Pixels in TYPE_INT_RGB format 
// (ie. 0xFFrrggbb, where rr is two bytes red, gg two bytes green etc)
int[] pixelvector = new int[w * h]; 

BufferedImage image_share1 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
WritableRaster rast = image_share1.getRaster(); // Faster! No copy, and live updated
rast.setDataElements(0, 0, w, h, pixelvector);
// No need to call setData, as we modified image_share1 via it's raster

ImageIO.write(image_share1,"JPG",new File("share1.jpg"));