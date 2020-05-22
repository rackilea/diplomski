BufferedImage image;
for(int y = 0; y < image.getHeight(); y++)
    for(int x = 0; x < image.getWidth(); x++)
    {
        Color imageColor = new Color(image.getRGB(x, y));
        //mix imageColor and desired color 
        image.setRGB(x, y, imageColor.getRGB());
    }