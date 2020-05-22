// get the pixels
Color p1 = new Color(im.getRGB(y - 1, x-1));
Color p2 = new Color(im.getRGB(y, x - 1));
Color p3 = new Color(im.getRGB(y + 1, x - 1));
Color p4 = new Color(im.getRGB(y - 1, x));
Color p5 = new Color(im.getRGB(y, x));
Color p6 = new Color(im.getRGB(y + 1, x));
Color p7 = new Color(im.getRGB(y - 1, x + 1));
Color p8 = new Color(im.getRGB(y, x + 1));
Color p9 = new Color(im.getRGB(y + 1, x + 1));
// blur all components separately
int r = (p1.getRed() + p2.getRed() + p3.getRed() + 
         p4.getRed() + p5.getRed() + p6.getRed() + 
         p7.getRed() + p8.getRed() + p9.getRed()) / 9;
int g = (p1.getGreen() + p2.getGreen() + p3.getGreen() + 
         p4.getGreen() + p5.getGreen() + p6.getGreen() + 
         p7.getGreen() + p8.getGreen() + p9.getGreen()) / 9;
int b = (p1.getBlue() + p2.getBlue() + p3.getBlue() + 
         p4.getBlue() + p5.getBlue() + p6.getBlue() + 
         p7.getBlue() + p8.getBlue() + p9.getBlue()) / 9;
// write back result
blurredim.setRGB(y, x, b + (g << 8) + (r << 16));