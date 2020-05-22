File file= new File("tardis.jpg");
BufferedImage image = ImageIO.read(file);
int rgb = image.getRGB(42, 42); 

int red   = (rgb & 0x00ff0000) >> 16;
int green = (rgb & 0x0000ff00) >> 8;
int blue  =  rgb & 0x000000ff;