int height=41;
int width=20;
int[] data = {...};

BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
for ( int x = 0; x < width; x++ ) {
  for ( int y = 0; y < height; y++ ) {
  // fix this based on your rastering order
  final int c = data[ y * width + x ];
  // all of the components set to the same will be gray
  bi.setRGB(x,y,new Color(c,c,c).getRGB() );
  }
}
File out = new File("image.jpg");
ImageIO.write(bi, "jpg", out);