public byte[] getImage() throws IOException {
    final int width = getWidth();
    final int width = getHeight();
    final BufferedImage image = new BufferedImage( width, height, TYPE_INT_RGB );
    final Graphics2D graphics = createGraphics2D();
    graphics.drawImage( image, null, null );

    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write( image, "png", baos );
    baos.flush();

    final byte[] result = baos.toByteArray();
    baos.close();

    return result;
}