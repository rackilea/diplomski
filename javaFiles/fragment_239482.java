int pixel = bwgImage.getRGB(w,h);
Color bwg = new Color(pixel);
int c=bwg.getRed();
Color red = new Color(c,0,0);
int cpixel = red.getRGB();
bwgImage.setRGB(w,h,cpixel);