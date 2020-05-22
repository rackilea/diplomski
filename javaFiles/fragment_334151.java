private BufferedImage createImage(int[][] pixelData, BufferedImage outputImage)
    {
    int[] outputImagePixelData = ((DataBufferInt) outputImage.getRaster().getDataBuffer()).getData() ;

    final int width = outputImage.getWidth() ;
    final int height = outputImage.getHeight() ;

    for (int y=0, pos=0 ; y < height ; y++)
        for (int x=0 ; x < width ; x++, pos++)
            outputImagePixelData[pos] = pixelData[y][x] ;

    return outputImage;
    }