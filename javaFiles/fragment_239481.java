int pixel = bwgImage.getRGB(w,h);
Color bwg = new Color(pixel);
float c = (0.2126f * bwg.getRed() + 0.7152f * bwg.getGreen() + 0.0722f * bwg.getBlue());
int cc = (int)Math.round(c);
Color red = new Color(cc, 0, 0);
int cpixel = red.getRGB();
bwgImage.setRGB(w,h,cpixel);