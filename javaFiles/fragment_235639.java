public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width; col++)
      {
        if (col < pixels.length)
        {
            pixel1 = pixels[row][col];
            pixel2 = pixels[col][row];
            pixel1.setColor(pixel2.getColor());
        }
      }
    } 
  }