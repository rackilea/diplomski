final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

for (int y = 0; y < height; y++)
{
  for (int x = 0; x < width; x++)
  {
    image.setRGB(x, y, color);
  }
}