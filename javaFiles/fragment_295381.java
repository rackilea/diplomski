Color c1 = new Color(rgb1[rgbIndex]);
Color c2 = new Color(rgb2[rgbIndex]);
Color cA = new Color((c1.getRed()   + c2.getRed())/2,
                     (c1.getGreen() + c2.getGreen())/2,
                     (c1.getBlue()  + c2.getBlue())/2);
rgb1[rgbIndex] = cA.getRGB();