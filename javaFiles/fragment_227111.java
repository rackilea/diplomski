private static void setPixelData(
  int x, int y,
  int alpha, int red, int green, int blue
) {
    int setPixel = (alpha << 24) | (red << 16) | (green << 8) | (blue);
    image.setRGB(x, y, setPixel);
    // Why overwrite the value you just set?
    image.setRGB(x, y, new Color(red,green,blue).getRGB());
}