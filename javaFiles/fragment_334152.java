private BufferedImage createImage(int[][] pixelData)
    {
    final int width = pixelData[0].length ;
    final int height = pixelData.length ;
    // First I create a BufferedImage with a DataBufferInt, with the appropriate dimensions and number of channels/bands/colors
    ColorSpace myColorSpace = new FloatCS(ColorSpace.TYPE_GRAY, channel) ;
    int[] bits = new int[]{32} ;
    ColorModel myColorModel = new ComponentColorModel(myColorSpace,bits,false,false,ColorModel.OPAQUE,DataBuffer.TYPE_INT) ;
    BufferedImage outputImage = new BufferedImage(myColorModel, myColorModel.createCompatibleWritableRaster(width, height), false, null) ;

    int[] outputImagePixelData = ((DataBufferInt) outputImage.getRaster().getDataBuffer()).getData() ;

    for (int y=0, pos=0 ; y < height ; y++)
        for (int x=0 ; x < width ; x++, pos++)
            outputImagePixelData[pos] = pixelData[y][x] ;

    return outputImage ;
    }