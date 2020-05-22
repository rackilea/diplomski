File file = new File("mygamedata.jpg");
BufferedImage image = ImageIO.read(file);

// Getting pixel color at position x, y (width, height)
int colour =  image.getRGB(x ,y); 
int red    = (colour & 0x00ff0000) >> 16;
int green  = (colour & 0x0000ff00) >> 8;
int blue   =  colour & 0x000000ff;
System.out.println("Red colour component = " + red);
System.out.println("Green colour component = " + green);
System.out.println("Blue colour component = " + blue);