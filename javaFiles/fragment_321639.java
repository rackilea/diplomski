public static boolean contains(Image large, Image small) {
  final int largeWidth = large.getWidth(), largeHeight = large.getHeight();
  final int smallWidth = small.getWidth(), smallHeight = small.getHeight();

  if (smallWidth > largeWidth || smallHeight > largeHeight) {
    return false;
  }

  for (int x = 0; x < largeWidth - smallWidth; x++) {
    for (int y = 0; y < largeHeight - smallHeight; y++) {
      if (subImageEquals(large, x, y, small)) {
        return true;
      }
    }
  }
  return false;
}

private static boolean subImageEquals(Image large, int x, int y, Image small) {
  // TODO: checks whether all pixels starting at (x, y) match
  // those of the small image.
}