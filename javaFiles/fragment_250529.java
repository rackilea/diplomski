BufferedImage img = ImageIO.read(new File("image which you want to change the pixels"));
for(int width=0; width < img.getWidth(); width++)
{
    for(int height=0; height < img.getHeight(); height++)
    {
          Color temp = new Color(p[pixel_value][red], p[pixel_value][green], p[pixel_value][blue]);
          img.setRGB(width, height, temp.getRGB());
    }
}
ImageIO.write(img, "jpg", new File("where you want to store this new image"));