BufferedImage bImg = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_BYTE_GRAY);
Graphics2D g=bImg.createGraphics();
g.drawImage(img,null,null);


WritableRaster raster=bImg.getRaster();
        int[] iArray=new int[1];
        for(int i=0;i<215;i++)
            for(int j=0;j<215;j++){
                raster.getPixel(i, j, iArray);
                iArray[0]=0;
                raster.setPixel(i, j, iArray);
            }