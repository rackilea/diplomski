private Image TransformGrayToTransparency(BufferedImage image)
  {
    ImageFilter filter = new RGBImageFilter()
    {
      public final int filterRGB(int x, int y, int rgb)
      {
        return (rgb << 8) & 0xFF000000;
      }
    };

    ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
  }