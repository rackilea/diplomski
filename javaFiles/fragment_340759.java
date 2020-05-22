private BufferedImage convertColors(BufferedImage img, int oldColor, int newColor)
{
    int [] pixels = new int [img.getWidth() * img.getHeight()];
    img.getRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
    Color old = new Color(oldColor);
    Color newC = new Color(newColor);

    for(int x = 0; x < img.getWidth(); x++)
    {
        for(int y = 0; y < img.getHeight(); y++)
        {
            Color tmp = new Color(pixels[x + y * img.getWidth()]);
            if(tmp.equals(old))
            {
                pixels[x + y * img.getWidth()] = newC.getRGB();
            }
        }
    }
    img.setRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());

    return newImg;
}