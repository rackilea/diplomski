for (int y = 0; y < pixmap.getHeight(); y++) {
  for (int x = 0; x < pixmap.getWidth(); x++) {
      if (pixmap.getPixel(x, y) == Color.rgb888(Color.Red))
      {
        pixmap.drawPixel(x, y, Color.Green);
      }
  }
}