// read an image from the disk
     BufferedImage image = ImageIO.read(new File("kittens.jpg"));

     setPreferredSize(new Dimension(
         image.getWidth(),image.getHeight()));

     // create a grayscale image the same size
     gray = new BufferedImage(image.getWidth(),image.getHeight(),
         BufferedImage.TYPE_BYTE_GRAY);

     // convert the original colored image to grayscale
     ColorConvertOp op = new ColorConvertOp(
         image.getColorModel().getColorSpace(),
         gray.getColorModel().getColorSpace(),null);
     op.filter(image,gray);

     //convert BuffuredImage to raw byte array
     WritableRaster raster = gray.getRaster();
     DataBufferByte data = (DataBufferByte) raster.getDataBuffer();    
     byte[] rawPixels = data.getData();