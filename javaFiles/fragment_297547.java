public static void processImage( BufferedImage source )
{
    ColorSpace colorSpace = source.getColorModel().getColorSpace();
    if ( dumpColorSpaceProperties ) {
        System.out.printf( "color space type: %d, is RGB = %s%n", colorSpace.getType(), colorSpace.isCS_sRGB() );
        for ( int i = 0; i < colorSpace.getNumComponents(); i++ ) {
            System.out.printf( "component %d = %s%n", i, colorSpace.getName( i ) );
        }
    }

    if ( colorSpace.getType() == ColorSpace.TYPE_RGB ) {
        // guaranteed RGB(A) order, proceed with raster.getPixels()
    } else {
        // well, find a way to convert from that space into RGB
        throw new AssertionError( "color space type = " + colorSpace.getType() );
    }
}