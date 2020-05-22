BufferedImage bi = ImageIO.read( new File( "image.png" ) );
int[] data = ( (DataBufferInt) bi.getRaster().getDataBuffer() ).getData();
for ( int i = 0 ; i < data.length ; i++ ) {
    Color c = new Color(data[i]);
    // RGB is now accessible as
    c.getRed();
    c.getGreen();
    c.getBlue();
}