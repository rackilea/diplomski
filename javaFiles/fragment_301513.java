BufferedImage image = ImageIO.read(urlImage);
int c = image.getRGB(x,y);
int  red = (c & 0x00ff0000) >> 16;
int  green = (c & 0x0000ff00) >> 8;
int  blue = c & 0x000000ff;
// and the Java Color is ...
Color color = new Color(red,green,blue);