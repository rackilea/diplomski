BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_BYTE_GRAY);           
        PImage pimage = new PImage(image.getWidth(),image.getHeight(),PConstants.ARGB);

        //fill up the databuffer using a converted Kinect Grayscale Image
        DataBufferByte dataBuffer = new DataBufferByte(graphicP.getImage(ImageType.GRAYSCALE), this.imageWidth * this.imageHeight);
        Raster raster = Raster.createPackedRaster(dataBuffer,imageWidth, imageHeight, 8, null);
        image.setData(raster);