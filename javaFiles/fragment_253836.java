int x,y; //populated from Mouse coordinates
int rgb = myBufferedImage.getPixel(x,y);

//to extract colors    
int red = (rgb & 0x00ff0000) >> 16;
int green = (rgb & 0x0000ff00) >> 8;
int blue = rgb & 0x000000ff;

// and to create a new Java color
Color c = new Color(red,blue,green);