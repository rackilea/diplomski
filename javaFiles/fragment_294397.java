private Image TransformColorToTransparency(BufferedImage image, Color c1, Color c2)
  {
    // Primitive test, just an example
    final int r1 = c1.getRed();
    final int g1 = c1.getGreen();
    final int b1 = c1.getBlue();
    final int r2 = c2.getRed();
    final int g2 = c2.getGreen();
    final int b2 = c2.getBlue();
    ImageFilter filter = new RGBImageFilter()
    {
      public final int filterRGB(int x, int y, int rgb)
      {
        int r = (rgb & 0xFF0000) >> 16;
        int g = (rgb & 0xFF00) >> 8;
        int b = rgb & 0xFF;
        if (r >= r1 && r <= r2 &&
            g >= g1 && g <= g2 &&
            b >= b1 && b <= b2)
        {
          // Set fully transparent but keep color
          return rgb & 0xFFFFFF;
        }
        return rgb;
      }
    };

    ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
      return Toolkit.getDefaultToolkit().createImage(ip);
  }