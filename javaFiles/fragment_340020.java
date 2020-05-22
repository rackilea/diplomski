public boolean areAllTheSame(int[][] image) {
  // assuming `image` >= 1x1 pixels

  int expectedPixel = image[0][0];

  for (int[] pixels: image)
    for (int pixel: pixels)
      if(pixel != expectedPixel)
        return false;

  return true;
}